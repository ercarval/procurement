package org.bisso.commons.repository;

import java.sql.ResultSet;
import java.util.List;

public interface ResultMapping {

	List mapping (ResultSet rset) throws Exception ;
	
}
