package fr.doranco.KlikBook.utils;

import java.text.SimpleDateFormat;

public final class Dates {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	private Dates() {
	}
	
	public static final java.util.Date convertStringToDateUtil(String dateStr) throws java.text.ParseException {
		return formatter.parse(dateStr);
	}
	
	public static final String convertDateUtilToString(java.util.Date date) {
		return formatter.format(date);
	}
	
	public static final java.util.Date convertDateSqlToDateUtil(java.sql.Date sqlDate) {
		if (sqlDate != null)
			return new java.util.Date(sqlDate.getTime());
		return null;
	}
	
	public static final java.sql.Date convertDateUtilToDateSql(java.util.Date utilDate) {
		if (utilDate != null)
			return new java.sql.Date(utilDate.getTime());
		return null;
	}

}
