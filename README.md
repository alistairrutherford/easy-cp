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



