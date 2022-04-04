public class dbload {
    public static void main(String[] args) {

        String path = "../../" + args[2];
        int pageSize = Integer.parseInt(args[1]);
        System.out.println(pageSize);

        CSVReader reader = new CSVReader(pageSize, path);
        long start = System.currentTimeMillis();
// ...
        HeapFileHai res = reader.read();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(res + ", Time elapsed(milliseconds): " + timeElapsed + "ms");
    }
}

// ~/Dat_a1/src/dbload