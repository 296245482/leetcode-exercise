package com.jackie;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AntTest {
    public static void main(String[] args) throws Exception {
        String[] arr = {"1", "1", "1", "1", "1", "1",
                "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",
                "3", "3", "3", "3", "3",
                "4", "4", "4", "4", "4", "4", "4", "4",
                "5", "5", "5", "5", "5",
                "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6",
                "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",};
        long start = System.currentTimeMillis();
        System.out.println(count(arr));
        System.out.println("执行用时：" + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        System.out.println(count2(arr));
        System.out.println("执行用时：" + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        System.out.println(count3(arr));
        System.out.println("执行用时：" + (System.currentTimeMillis() - start3));
    }

    private static Map<String, Integer> count(String[] arr) throws Exception {
        final Map<String, Integer> charCountMap = new HashMap<>();

        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        String[][] arrSplit = split(arr, numThreads);

        for (int i = 0; i < numThreads; i++) {
            final String[] argsTemp = arrSplit[i];
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for (final String character : argsTemp) {
                        synchronized (charCountMap) {
                            if (charCountMap.containsKey(character)) {
                                charCountMap.put(character, charCountMap.get(character) + 1);
                            } else {
                                charCountMap.put(character, 1);
                            }
                        }
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sort(charCountMap);
    }

    private static Map<String, Integer> count2(String[] arr) throws Exception {
        final ConcurrentHashMap<String, Integer> charCountMap = new ConcurrentHashMap<>();

        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        String[][] arrSplit = split(arr, numThreads);

        for (int i = 0; i < numThreads; i++) {
            final String[] argsTemp = arrSplit[i];
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for (final String character : argsTemp) {
                        if (charCountMap.containsKey(character)) {
                            charCountMap.put(character, charCountMap.get(character) + 1);
                        } else {
                            charCountMap.put(character, 1);
                        }
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sort(charCountMap);
    }

    private static Map<String, Integer> count3(String[] arr) throws Exception {
        final HashMap<String, AtomicInteger> charCountMap = new HashMap<>();

        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        String[][] arrSplit = split(arr, numThreads);

        for (int i = 0; i < numThreads; i++) {
            final String[] argsTemp = arrSplit[i];
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for (final String character : argsTemp) {
                        if (charCountMap.containsKey(character)) {
                            charCountMap.get(character).getAndIncrement();
                        } else {
                            charCountMap.put(character, new AtomicInteger(1));
                        }
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sort2(charCountMap);
    }

    public static Map<String, Integer> sort2(Map<String, AtomicInteger> map) {
        List<Map.Entry<String, AtomicInteger>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, AtomicInteger>>() {
            @Override
            public int compare(Map.Entry<String, AtomicInteger> o1, Map.Entry<String, AtomicInteger> o2) {
                // 倒序排序
                return o2.getValue().get() - o1.getValue().get();
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, AtomicInteger> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue().get());
        }
        return sortedMap;
    }

    public static Map<String, Integer> sort(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 倒序排序
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static String[][] split(String[] arr, int partsNum) {
        int arrLength = arr.length;
        int partSize = arrLength / partsNum + 1;

        String[][] result = new String[partsNum][];
        int startIndex = 0;
        for (int i = 0; i < partsNum; i++) {
            int endIndex = Math.min(arrLength, startIndex + partSize);
            result[i] = Arrays.copyOfRange(arr, startIndex, endIndex);
            startIndex = endIndex;
        }
        return result;
    }
}
