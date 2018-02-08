package com.sinohealth.cloud.vo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DataFramePlus {
	/**
	 * 根据列名查找列索引
	 */
	public Map<String, Integer> field2Index;
	
	/**
	 * 根据列索引查找列名
	 */
	public Map<Integer, String> index2Field;
	
	/**
	 * 维度
	 */
	public int[] dimensions;
	
	/**/
	public double[][] data;
	
	/**
	 * 转置后的数据
	 */
	public double[][] dataTransposed;

	/**
	 * message
	 */
	public String message;
	
	/**
	 * flag 
	 */
	public Boolean flag;
	

	//测试方法
	public static void main(String[] args) throws Exception {
		double[][] matrixData = { {1d,2d,3d}, {2d,5d,3d}};
		
		DataFramePlus df = new DataFramePlus();
		df.setData(matrixData);
		String[] fields = {"c0", "c1"};
		DataFramePlus.setFieldIndex(df, fields);
		String json = bean2Json(df);
//		System.out.println(json);
//		System.out.println(df);
		DataFramePlus d = json2Bean(json, DataFramePlus.class);
		
		ArrayList<DataFramePlus> list = new ArrayList<DataFramePlus>();
		list.add(new DataFramePlus());
		list.add(new DataFramePlus());
		DataFramePlus dfp = new DataFramePlus();
		Map map = new HashMap<String, Integer>();
		map.put("haha", 1);
		dfp.setField2Index(map);
		
		
		
		
		
		list.add(dfp);
		list.add(new DataFramePlus());
		
		String jsons = bean2Json(list);
		
		System.out.println(jsons);
		
//		double[] column = d.transfer2RealMatrix().getColumn(1);
//		for (double c: column) {
////			System.out.println(c);
//		}
////		System.out.println(d.transfer2RealMatrix().getColumn(1));
////		System.out.println(DataFramePlus);
//		
//		for (double c: df.getRow(1)) {
//			System.out.println(c);
//		}
//		
//		for (double c: df.getColumn(1)) {
//			System.out.println(c);
//		}
//		
//		for (double c: df.getColumn("c0")) {
//			System.out.println(c);
//		}
	}

	/**
	 * 转换成RealMatrix
	 * @return
	 */
	public RealMatrix transfer2RealMatrix() {
		return transfer2RealMatrix(this.data);
	}
	
	/**
	 * 根据行索引获取行数据
	 * @param rowIndex
	 * @return
	 */
	public double[] getRow(int rowIndex) {
		return this.data[rowIndex];
	}
	
	/**
	 * 根据列索引获取列数据
	 * @param columnIndex
	 * @return
	 */
	public double[] getColumn(int columnIndex) {
		return this.dataTransposed[columnIndex];
	}
	
	/**
	 * 根据列名获取列数据
	 * @param field
	 * @return
	 */
	public double[] getColumn(String field) {
		return this.dataTransposed[field2Index.get(field)];
	}
	
	/**
	 * 转换成RealMatrix
	 * @param data
	 * @return
	 */
	public static RealMatrix transfer2RealMatrix(double[][] data) {
		RealMatrix m = MatrixUtils.createRealMatrix(data);
		return m;
	}
	
	/**
	 * 转换成json
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	public static String bean2Json(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();
        JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
        mapper.writeValue(gen, obj);
        gen.close();
        return sw.toString();
    }

	/**
	 * json转换成bean
	 * @param jsonStr
	 * @param objClass
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
    public static <T> T json2Bean(String jsonStr, Class<T> objClass)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, objClass);
    }
	
    /**
     * 设置列名和列索引
     * @param df
     * @param fields
     */
	public static void setFieldIndex(DataFramePlus df, String[] fields) {
		if (df == null || fields == null || fields.length == 0) {
			return;
		}
		Map<String, Integer> field2Index = df.getField2Index();
		Map<Integer, String> index2Field = df.getIndex2Field();
		field2Index = new HashMap<String, Integer>();
		index2Field = new HashMap<Integer, String>();
		for (int i = 0; i < fields.length; i++) {
			field2Index.put(fields[i], i);
			index2Field.put(i, fields[i]);
		}
		df.setField2Index(field2Index);
		df.setIndex2Field(index2Field);
	}
	

	public Map<String, Integer> getField2Index() {
		return field2Index;
	}

	public void setField2Index(Map<String, Integer> field2Index) {
		this.field2Index = field2Index;
	}

	public Map<Integer, String> getIndex2Field() {
		return index2Field;
	}

	public void setIndex2Field(Map<Integer, String> index2Field) {
		this.index2Field = index2Field;
	}

	public int[] getDimensions() {
		return dimensions;
	}

	public void setDimensions(int[] dimensions) {
		this.dimensions = dimensions;
	}

	public double[][] getData() {
		return data;
	}

	public void setData(double[][] data) {
		if (data == null || data.length == 0 || data[0].length == 0) {
			return;
		}
		this.data = data;
		int r = data.length;
		int c = data[0].length;
		this.dimensions = new int[] {r, c};
		
		this.dataTransposed = new double[c][r];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				this.dataTransposed[j][i] = data[i][j];
			}
		}
	}
	
	public double[][] getDataTransposed() {
		return dataTransposed;
	}

	public void setDataTransposed(double[][] dataTransposed) {
		this.dataTransposed = dataTransposed;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "DataFramePlus [field2Index=" + field2Index + ", index2Field=" + index2Field + ", dimensions="
				+ Arrays.toString(dimensions) + ", data=" + Arrays.toString(data) + ", dataTransposed="
				+ Arrays.toString(dataTransposed) + ", message=" + message + ", flag=" + flag + "]";
	}


	
	

}