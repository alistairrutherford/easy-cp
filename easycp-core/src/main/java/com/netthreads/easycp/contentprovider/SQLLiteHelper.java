package com.netthreads.easycp.contentprovider;

import java.util.HashMap;
import java.util.Map;

/**
 * This borrows from Active Objects.
 *
 */
public class SQLLiteHelper
{
	public enum SQLiteType
	{
		INTEGER, REAL, TEXT, BLOB
	}

	@SuppressWarnings("serial")
	public static final Map<Class<?>, SQLiteType> TYPE_MAP = new HashMap<Class<?>, SQLiteType>()
	{
		{
			put(byte.class, SQLiteType.INTEGER);
			put(short.class, SQLiteType.INTEGER);
			put(int.class, SQLiteType.INTEGER);
			put(long.class, SQLiteType.INTEGER);
			put(float.class, SQLiteType.REAL);
			put(double.class, SQLiteType.REAL);
			put(boolean.class, SQLiteType.INTEGER);
			put(char.class, SQLiteType.TEXT);
			put(byte[].class, SQLiteType.BLOB);
			put(Byte.class, SQLiteType.INTEGER);
			put(Short.class, SQLiteType.INTEGER);
			put(Integer.class, SQLiteType.INTEGER);
			put(Long.class, SQLiteType.INTEGER);
			put(Float.class, SQLiteType.REAL);
			put(Double.class, SQLiteType.REAL);
			put(Boolean.class, SQLiteType.INTEGER);
			put(Character.class, SQLiteType.TEXT);
			put(String.class, SQLiteType.TEXT);
			put(Byte[].class, SQLiteType.BLOB);
		}
	};
}
