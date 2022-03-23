import java.util.ArrayList;

public class HeapFileHai
{
    private ArrayList<Page> pages = new ArrayList<>();
    private int currPage = 0, numOfRecords = 0;
    public HeapFileHai()
    {
        pages.add(new Page());
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
        public int pagesize = 1024;
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
        private String personName, nationality_label, thumbnail;
        public int size;
        public Record(String personName, String nationality_label, String thumbnail)
        {
            this.personName = personName;
            this.nationality_label = nationality_label;
            this.thumbnail = thumbnail;
            size += !personName.equals("NULL") ? personName.length() : 0;
            size += !nationality_label.equals("NULL") ? nationality_label.length() : 0;
            size += !thumbnail.equals("NULL") ? thumbnail.length() : 0;
        }
        public String toString()
        {
            return "Size: " + size + "_" + personName + "_" + nationality_label + "_" + thumbnail;
        }
    }
}
