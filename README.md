easycp
======

Easy CP - Makes creating an Android Content Provider a breeze.

Usage is simple.

1) Define your table. Note the '_ID' column required by Content Providers is automatically added for you.

	@Table(name = "test_table")
	private class TestTable implements BaseColumns
	{
		@Column(name = "column1")
		private String column1;
		
		@Column(name = "column2")
		private String column2;
		
		@Column(name = "column3")
		private String column3;
		
		@Column(name = "column4")
		private String column4;
		
	}

2) Define your Content Provider subclassing from EasyContentProvider.

	@ContentProvider(database = TestContentProvider.DATABASE, 
			authority = TestContentProvider.AUTHORITY, 
			tableClass = TestTable.class, 
			version = 1)
	public class TestContentProvider extends EasyContentProvider
	{
    		public static final String DATABASE = "testdb.db";
    		public static final String AUTHORITY = "com.netthreads.easycp.test";
	
		// Your provider.
	}
	
3) Reference the content provider in your AnroidManifest.xml i.e.

        <provider
            android:authorities="com.netthreads.easycp.test"
            android:name="com.netthreads.easycp.test.TestContentProvider" >
        </provider>

4) Example

There is a nice example of this in use here https://github.com/alistairrutherford/traffic-ha-rss

I have used this component to implement persistence in an application which downloads traffic events and has a RecyclerView list adapter build a view onto the database items.

