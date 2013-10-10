/*
 * -----------------------------------------------------------------------
 * Copyright 2013 - Alistair Rutherford - www.netthreads.co.uk
 * -----------------------------------------------------------------------
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.netthreads.easycp.test;

import org.junit.Test;

import android.provider.BaseColumns;

import com.netthreads.easycp.annotation.Column;
import com.netthreads.easycp.annotation.ContentProvider;
import com.netthreads.easycp.annotation.Table;
import com.netthreads.easycp.contentprovider.EasyContentProvider;
import com.netthreads.easycp.contentprovider.SQLLiteHelper.SQLiteType;
import com.netthreads.easycp.contentprovider.Schema;

/**
 * Test annotations.
 * 
 */
public class TestAnnotations
{
	private static final String TEST_DATABASE_NAME = "testdb.db";
	private static final String TEST_AUTHORITY = "com.netthreads.easycp.test";
	
	private static final String TEST_TABLE_NAME = "test_table";
	private static final String[] COLUMN_NAMES =
	{
		BaseColumns._ID, "column1", "column2", "column3", "column4"
	};
	
	@Table(name = TEST_TABLE_NAME)
	private class TestTable implements BaseColumns
	{
		@Column(name = _ID)
		private Long id;
		
		@Column(name = "column1")
		private String column1;
		
		@Column(name = "column2")
		private String column2;
		
		@Column(name = "column3")
		private String column3;
		
		@Column(name = "column4")
		private String column4;
		
	}
	
	@ContentProvider(database = TEST_DATABASE_NAME, authority = TEST_AUTHORITY, tableClass = TestTable.class, version = 1)
	private class TestContentProvider extends EasyContentProvider
	{
		// Test content provider.
	}
	
	/**
	 * Test Schema annotations.
	 */
	@Test
	public void testAnnotation()
	{
		Schema tableColumns = new Schema(TestContentProvider.class);
		
		org.junit.Assert.assertTrue(tableColumns.getDatabaseName().equals(TEST_DATABASE_NAME));
		
		org.junit.Assert.assertTrue(tableColumns.getAuthorityName().equals(TEST_AUTHORITY));
		
		org.junit.Assert.assertTrue(tableColumns.getTableName() != null);
		
		org.junit.Assert.assertTrue(!tableColumns.getTableName().isEmpty());
		
		org.junit.Assert.assertTrue(tableColumns.getTableName().equals(TEST_TABLE_NAME));
		
		for (String columnName : COLUMN_NAMES)
		{
			SQLiteType target = tableColumns.getColumnDefinitions().get(columnName);
			
			org.junit.Assert.assertTrue(target != null);
		}
	}

}
