import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {

        String path = "D:/artist.csv";
        String line = "";
        HeapFileHai hf = new HeapFileHai();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) !=null){
//                System.out.println(line);
                String [] att = line.split(",");
                att[1] = att[1].substring(1,att[1].length()-1);
                att[2] = att[2].substring(1,att[2].length()-1);
                att[3] = att[3].substring(1,att[3].length()-1);
                HeapFileHai.Record record = hf.new Record(att[1], att[2], att[3]);
                hf.AddRecord(record);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(hf);
        System.out.println(hf.getPage(245).getRecord(0));
    }

}
