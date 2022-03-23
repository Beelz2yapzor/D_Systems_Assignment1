public class HeapFile {
    private byte pagesize;


    public HeapFile(String fileName)
    {
        //Creates new file if not fileName given is not found, otherwise is opened
    }

    public void deleteFile()
    {
        //deletes file from database
    }

    public RecordID insertRecord(byte[] record)
    {
        //inserts record into file, returns an ID
    }
    public byte[] selectRecord(RecordID rid)
    {
        //reads a record from the file, given id
    }

    public byte[] updateRecord(RecordID rid)
    {
        //reads a record from the file, given id
    }

    public byte[] deleteRecord(RecordID rid)
    {
        //reads a record from the file, given id
    }

    public int getVolume()
    {
        //gets the amount of records in the file
    }
    public HeapScan openScan()
    {
        //initiates a scan of the file
    }
    public String toString()
    {
        //returns name of file
    }
}