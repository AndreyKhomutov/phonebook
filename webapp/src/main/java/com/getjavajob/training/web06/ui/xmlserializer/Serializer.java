package com.getjavajob.training.web06.ui.xmlserializer;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer {

    public List<Employee> fromXML (File file) throws FileNotFoundException {
        List<Employee> employees=new ArrayList<>();
        XStream xStream=new XStream(new DomDriver());
        InputStream inputStream=null;
        inputStream=new BufferedInputStream(new FileInputStream(file));
        employees= (List<Employee>) xStream.fromXML(inputStream);
        return employees;
    }

    public void toXML (List<Employee> employees, File file) throws FileNotFoundException {
     XStream xStream=new XStream(new DomDriver());
        OutputStream outputStream=null;
        outputStream=new BufferedOutputStream(new FileOutputStream(file));
        xStream.toXML(employees, outputStream);
    }
}
