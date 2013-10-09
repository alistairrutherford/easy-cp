package com.netthreads.easycp.contentprovider;

import java.util.Collection;
import java.util.Map;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * This class helps open, create, and upgrade the database file.
 * 
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
	private static final String TAG = "DatabaseHelper";

	private Schema schema;

	/**
	 * Construct database helper.
	 * 
	 * @param context
	 * @param schema
	 */
	DatabaseHelper(Context context, Schema schema)
	{
		super(context, schema.getDatabaseName(), null, schema.getDatabaseVersion());

		this.schema = schema;
	}

	/**
	 * Create database.
	 * 
	 * @param db
	 */
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		String createSQL = "CREATE TABLE " +
                            schema.getTableName() +
                            " (" +
                            schema.getIdField() +
                            " INTEGER PRIMARY KEY AUTOINCREMENT ";

		Map<String, SQLLiteHelper.SQLiteType> columnDefinitions = schema.getColumnDefinitions();

		StringBuilder defineColumns = new StringBuilder();
		Collection<String> columnNames = columnDefinitions.keySet();
		for (String columnName : columnNames)
		{
			SQLLiteHelper.SQLiteType sqLiteType = columnDefinitions.get(columnName);
			defineColumns.append(",");
			defineColumns.append(columnName);
			defineColumns.append(" ");
			defineColumns.append(sqLiteType.name());
		}

		createSQL += defineColumns.toString() + ");";

        try
        {
		    db.execSQL(createSQL);
        }
        catch (SQLException e)
        {
            Log.e("DatabaseHelper", e.getLocalizedMessage());
        }
	}

	/**
	 * Upgrade database.
	 * 
	 * @param db
	 * @param oldVersion
	 * @param newVersion
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");

		db.execSQL("DROP TABLE IF EXISTS " + schema.getTableName());

		onCreate(db);
	}
}
