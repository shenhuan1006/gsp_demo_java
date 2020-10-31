package gudusoft.gsqlparser.dlineage.dataflow.metadata;

import java.util.ArrayList;
import java.util.List;

import gudusoft.gsqlparser.dlineage.dataflow.metadata.model.MetadataRelation;

public class MetadataReader {
	public static List<MetadataRelation> read(String metadata) {
		List<MetadataRelation> relations = new ArrayList<MetadataRelation>();
		String[] lines = metadata.replace("\r", "").trim().split("(\n)+");
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String[] columns = line.trim().split("\\s*;\\s*");
			if (i == 0 && columns[0].toLowerCase().indexOf("source_db") != -1) {
				continue;
			}
			if (columns.length >= 8) {
				MetadataRelation relation = new MetadataRelation();
				relation.setSourceDb(columns[0]);
				relation.setSourceSchema(columns[1]);
				relation.setSourceTable(columns[2]);
				relation.setSourceColumn(columns[3]);
				relation.setTargetDb(columns[4]);
				relation.setTargetSchema(columns[5]);
				relation.setTargetTable(columns[6]);
				relation.setTargetColumn(columns[7]);
				if (columns.length >= 9) {
					relation.setProcedureName(columns[8]);
				}
				if (columns.length >= 10) {
					relation.setQueryName(columns[9]);
				}
				relations.add(relation);
			}
		}

		return relations;
	}

	public static boolean isMetadata(String metadata) {
		String[] lines = metadata.replace("\r", "").trim().split("(\n)+");
		for (int i = 0; i < lines.length;) {
			String line = lines[i];
			String[] columns = line.trim().split("\\s*;\\s*");
			if (i == 0) {
				if (columns[0].toLowerCase().indexOf("source_db") != -1) {
					return true;
				}
				return false;
			} else {
				return false;
			}
		}
		return false;
	}
}
