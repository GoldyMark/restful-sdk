//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.07 at 09:30:00 AM EDT 
//

package org.restsql.core.sqlresource;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import mq.restful.util.RestUtil;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

/**
 * <p>
 * Java class for SqlResource complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SqlResource">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="query" type="{http://restsql.org/schema}Query"/>
 *         &lt;element name="metadata" type="{http://restsql.org/schema}MetaData"/>
 *         &lt;element name="validatedAttribute" type="{http://restsql.org/schema}ValidatedAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="http" type="{http://restsql.org/schema}HttpConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "sqlResource", namespace = "http://restsql.org/schema")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SqlResource", propOrder = { "description", "test", "query",
		"metadata", "validatedAttribute", "http" })
public class SqlResourceDefinition {
	@XmlElement(required = false)
	protected Test test;
	@XmlElement(required = true)
	protected Query query;
	@XmlElement(required = true)
	protected MetaData metadata;
	@XmlElement(required = false)
	protected Description description;
	@XmlElement(required = false)
	protected List<ValidatedAttribute> validatedAttribute;
	@XmlElement(required = false)
	protected HttpConfig http;

	@XmlTransient
	private ListMultimap<String, ValidatedAttribute> validatedAttributeMap;

	@XmlTransient
	private Map<String, String> formatMap;

	@XmlTransient
	private Map<String, Format> formatterMap;

	@XmlTransient
	private Map<String, String> regexMap;

	@XmlTransient
	private Map<String, String> replacementMap;

	/**
	 * Gets the value of the query property.
	 * 
	 * @return possible object is {@link Query }
	 * 
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * Sets the value of the query property.
	 * 
	 * @param value
	 *            allowed object is {@link Query }
	 * 
	 */
	public void setQuery(Query value) {
		this.query = value;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * Gets the value of the metadata property.
	 * 
	 * @return possible object is {@link MetaData }
	 * 
	 */
	public MetaData getMetadata() {
		return metadata;
	}

	/**
	 * Sets the value of the metadata property.
	 * 
	 * @param value
	 *            allowed object is {@link MetaData }
	 * 
	 */
	public void setMetadata(MetaData value) {
		this.metadata = value;
	}

	/**
	 * Gets the value of the validatedAttribute property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the validatedAttribute property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getValidatedAttribute().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ValidatedAttribute }
	 * 
	 * 
	 */
	public List<ValidatedAttribute> getValidatedAttribute() {
		if (validatedAttribute == null) {
			validatedAttribute = new ArrayList<ValidatedAttribute>();
		}
		return this.validatedAttribute;
	}

	public ListMultimap<String, ValidatedAttribute> getValidatedAttributeMap() {
		if (null == validatedAttributeMap) {
			validatedAttributeMap = ArrayListMultimap.create();

			if (null != validatedAttribute && validatedAttribute.size() > 0) {
				for (ValidatedAttribute v : validatedAttribute) {

					validatedAttributeMap.put(v.getName(), v);
				}
			}
		}
		return validatedAttributeMap;
	}

	public String getFormatPattern(String key) {

		if (null == formatMap) {
			formatMap = new HashMap<String, String>();

			ListMultimap<String, ValidatedAttribute> map = getValidatedAttributeMap();
			Set<String> keySet = map.keySet();
			for (String k : keySet) {
				List<ValidatedAttribute> vl = map.get(k);

				for (ValidatedAttribute va : vl) {

					if (RestUtil.stringNotNullOrEmpty(va.getFormat())) {
						formatMap.put(k, va.getFormat());
					}
				}
			}

		}

		return formatMap.get(key);
	}

	public Format getFormatter(String key) {
		if (null == formatterMap) {
			formatterMap = new HashMap<String, Format>();

			ListMultimap<String, ValidatedAttribute> map = getValidatedAttributeMap();
			Set<String> keySet = map.keySet();

			for (String k : keySet) {
				List<ValidatedAttribute> vl = map.get(k);

				for (ValidatedAttribute va : vl) {

					if (RestUtil.stringNotNullOrEmpty(va.getFormat())) {

						if (va.getType().equalsIgnoreCase(
								ValidatedAttributeType.Datetime.toString())) {
							formatterMap.put(k, new SimpleDateFormat(
									getFormatPattern(k)));
						} else if (va.getType().equalsIgnoreCase(
								ValidatedAttributeType.Numeric.toString())) {
							formatterMap.put(k, new DecimalFormat(
									getFormatPattern(k)));
						}

					}
				}
			}
		}

		return formatterMap.get(key);
	}

	public String getReplacement(String key) {

		if (null == replacementMap) {
			replacementMap = new HashMap<String, String>();

			ListMultimap<String, ValidatedAttribute> map = getValidatedAttributeMap();
			Set<String> keySet = map.keySet();
			for (String k : keySet) {
				List<ValidatedAttribute> vl = map.get(k);

				for (ValidatedAttribute va : vl) {

					if (va.getReplacement() != null) {
						replacementMap.put(k, va.getReplacement());
					}
				}
			}

		}

		return replacementMap.get(key);
	}

	public String getRegex(String key) {

		if (null == regexMap) {
			regexMap = new HashMap<String, String>();

			ListMultimap<String, ValidatedAttribute> map = getValidatedAttributeMap();
			Set<String> keySet = map.keySet();
			for (String k : keySet) {
				List<ValidatedAttribute> vl = map.get(k);

				for (ValidatedAttribute va : vl) {

					if (va.getRegex() != null) {
						regexMap.put(k, va.getRegex());
					}
				}
			}

		}

		return regexMap.get(key);
	}

	/**
	 * Gets the value of the http property.
	 * 
	 * @return possible object is {@link HttpConfig }
	 * 
	 */
	public HttpConfig getHttp() {
		return http;
	}

	/**
	 * Sets the value of the http property.
	 * 
	 * @param value
	 *            allowed object is {@link HttpConfig }
	 * 
	 */
	public void setHttp(HttpConfig value) {
		this.http = value;
	}

}