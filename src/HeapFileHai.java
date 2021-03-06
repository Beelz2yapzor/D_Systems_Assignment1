import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class HeapFileHai implements Serializable
{
    private ArrayList<Page> pages = new ArrayList<>();
    private int currPage = 0, numOfRecords = 0;
    private int pageSize = 0;
    public HeapFileHai(int pageSize)
    {
        pages.add(new Page());
        this.pageSize = pageSize;
    }
    public String toString()
    {
        return "Number of pages: " + pages.size() + ", Number of records: " + numOfRecords;
    }
    public void AddRecord(Record newRecord)
    {
        if(pages.get(currPage).AddRecord(newRecord) == true)
        {
            //write without gap
        }
        else
        {
            currPage++;
            pages.add(new Page());
            pages.get(currPage).AddRecord(newRecord);

            //write with gap
        }
        numOfRecords++;
//        try(FileOutputStream fos = new FileOutputStream("heap.pagesize");
//            ObjectOutputStream oos = new ObjectOutputStream(fos)){
//            oos.writeObject(newRecord);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // this function is to output a heap.pagesize file containing binary data of the fields. But i realised it takes very long to write down the whole output as i only managed to change interger to binary and not the remaining fields of data
    }
    public Page getPage(int idx)
    {
        return pages.get(idx);
    }
    public class Page implements Serializable
    {
        private ArrayList<Record> records = new ArrayList<>();
        public int pagesize = pageSize;
        public Page()
        {
        }
        public boolean AddRecord(Record newRecord)
        {
            if(pagesize - newRecord.size >= 0)
            {
                records.add(newRecord);
                pagesize -= newRecord.size;
                return true;
            }
            return false;
        }
        public String toString()
        {
            return " ";
        }
        public Record getRecord(int idx)
        {
            return records.get(idx);
        }

    }
    public class Record implements Serializable
    {
        private int wikiPageID;
        private String wiki2;
        private String personName, birthDate, birthPlace_label, deathDate, field_label, genre_label, instrument_label, nationality_label, thumbnail, description;
        public int size;
        public Record(String personName, String birthDate, String birthPlace_label, String deathDate , String field_label, String genre_label, String instrument_label, String nationality_label, String thumbnail, String wikiPageID, String description )
        {
            this.personName = personName;
            this.birthDate = birthDate;
            this.birthPlace_label = birthPlace_label;
            this.deathDate = deathDate;
            this.field_label = field_label;
            this.genre_label = genre_label;
            this.instrument_label = instrument_label;
            this.nationality_label = nationality_label;
            this.thumbnail = thumbnail;
            this.wikiPageID = wikiPageID.equals("NULL") ? 0 : Integer.parseInt(wikiPageID);
            this.description = description;

            // so this is to set when data is not null, the size will be its repesctive size, else if it is null make it 0.
            size += !personName.equals("NULL") ? personName.length() : 0;
            size += !birthDate.equals("NULL") ? birthDate.length() : 0;
            size += !birthPlace_label.equals("NULL") ? birthPlace_label.length() : 0;
            size += !deathDate.equals("NULL") ? deathDate.length() : 0;
            size += !field_label.equals("NULL") ? field_label.length() : 0;
            size += !genre_label.equals("NULL") ? genre_label.length() : 0;
            size += !instrument_label.equals("NULL") ? instrument_label.length() : 0;
            size += !nationality_label.equals("NULL") ? nationality_label.length() : 0;
            size += !thumbnail.equals("NULL") ? thumbnail.length() : 0;
            size += !wikiPageID.equals("NULL") ? 4 : 0; // because wikiPageID is integer it will be converted  to 4 bytes
            size += !description.equals("NULL") ? description.length() : 0;
        }
        public String toString()
        {
            // this code is redundant, it was just for me to test if the script was able to read and take the data
            return "Size: " + size + "//" + personName + "//"+ birthDate + "//" + birthPlace_label + "//"+ deathDate + "//" + field_label + "//" + genre_label + "//" + instrument_label + "//" + nationality_label + "//" + thumbnail + "//" + description + "//" + wikiPageID;
        }
    }
}
