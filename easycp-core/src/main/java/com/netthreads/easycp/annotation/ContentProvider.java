package com.netthreads.easycp.annotation;

import android.provider.BaseColumns;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(
{
	ElementType.TYPE
})
public @interface ContentProvider
{
	public static final String DEFAULT_ID = BaseColumns._ID;
	public static final String DEFAULT_DB = "";
	public static final String DEFAULT_AUTHORITY = "";

	public String database() default DEFAULT_DB;

	public String authority() default DEFAULT_AUTHORITY;

	public Class<?> tableClass();

	public int version();

	public String idField() default DEFAULT_ID;
}
