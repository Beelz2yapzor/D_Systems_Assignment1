import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    private int pageSize;
    private String path;
    public CSVReader(int pageSize, String path){
        this.pageSize = pageSize;
        this.path = path;
    }
    public HeapFileHai read() {

        String line = "";

        HeapFileHai hf = new HeapFileHai(pageSize);
//        HeapFileHai hf = new HeapFileHai(0);
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            for(int i = 0; i < 4; i++){
                line = br.readLine();
            }
            int j = 0;
            while((line = br.readLine()) !=null){
                System.out.println("data loaded "+ j);
                j++;
//                System.out.println(line);
                String [] att = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
//                System.out.println(att.length);
                att[1] = att[1].substring(1,att[1].length()-1);
                att[23] = att[23].substring(1,att[23].length()-1);
                att[25] = att[25].substring(1,att[25].length()-1);
                att[40] = att[40].substring(1,att[40].length()-1);
                att[50] = att[50].substring(1,att[50].length()-1);
                att[52] = att[52].substring(1,att[52].length()-1);
                att[62] = att[62].substring(1,att[62].length()-1);
                att[73] = att[73].substring(1,att[73].length()-1);
                att[124] = att[124].substring(1,att[124].length()-1);
                att[133] = att[133].substring(1,att[133].length()-1);
                att[137] = att[137].substring(1,att[137].length()-1);
                HeapFileHai.Record record = hf.new Record(att[1], att[23], att[25], att[40], att[50], att[52], att[62], att[75],att[124], att[133], att[137]);
                hf.AddRecord(record);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return hf;
//        System.out.println(hf.getPage(56).getRecord(1));
    }

}
