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
                att[27] = att[27].substring(1,att[27].length()-1);
                att[52] = att[52].substring(1,att[52].length()-1);
                att[54] = att[54].substring(1,att[54].length()-1);
                att[64] = att[64].substring(1,att[64].length()-1);
                att[75] = att[75].substring(1,att[75].length()-1);
                att[127] = att[127].substring(1,att[127].length()-1);
                att[139] = att[139].substring(1,att[139].length()-1);
                HeapFileHai.Record record = hf.new Record(att[1], att[27], att[52], att[54], att[64], att[75],att[126], att[139]);
                hf.AddRecord(record);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(hf);
        System.out.println(hf.getPage(30).getRecord(0));
    }

}
