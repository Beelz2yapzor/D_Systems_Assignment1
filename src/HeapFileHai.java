import java.util.ArrayList;
import java.util.Date;

public class HeapFileHai
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
            //nothing happen
        }
        else
        {
            currPage++;
            pages.add(new Page());
            pages.get(currPage).AddRecord(newRecord);
        }
        numOfRecords++;
    }
    public Page getPage(int idx)
    {
        return pages.get(idx);
    }
    public class Page
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
    public class Record
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
//            System.out.println(wikiPageID);
//            System.out.println(wikiPageID=="30865730");
//            this.wiki2 = wikiPageID;
            this.wikiPageID = wikiPageID.equals("NULL") ? 0 : Integer.parseInt(wikiPageID);
            this.description = description;


            size += !personName.equals("NULL") ? personName.length() : 0;
            size += !birthDate.equals("NULL") ? birthDate.length() : 0;
            size += !birthPlace_label.equals("NULL") ? birthPlace_label.length() : 0;
            size += !deathDate.equals("NULL") ? deathDate.length() : 0;
            size += !field_label.equals("NULL") ? field_label.length() : 0;
            size += !genre_label.equals("NULL") ? genre_label.length() : 0;
            size += !instrument_label.equals("NULL") ? instrument_label.length() : 0;
            size += !nationality_label.equals("NULL") ? nationality_label.length() : 0;
            size += !thumbnail.equals("NULL") ? thumbnail.length() : 0;
            size += !wikiPageID.equals("NULL") ? 4 : 0;
            size += !description.equals("NULL") ? description.length() : 0;
        }
        public String toString()
        {
            return "Size: " + size + "//" + personName + "//"+ birthDate + "//" + birthPlace_label + "//"+ deathDate + "//" + field_label + "//" + genre_label + "//" + instrument_label + "//" + nationality_label + "//" + thumbnail + "//" + description + "//" + wikiPageID;
        }
    }
}
