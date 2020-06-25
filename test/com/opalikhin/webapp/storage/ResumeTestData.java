package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Map<ContactType, Contact> contacts = new EnumMap<>(ContactType.class);

        contacts.put(ContactType.PHONE, new Contact(ContactType.PHONE, "+7(921) 855-0482"));
        contacts.put(ContactType.SKYPE, new Contact(ContactType.SKYPE, "grigory.kislin"));
        contacts.put(ContactType.EMAIL, new Contact(ContactType.EMAIL, "gkislin@yandex.ru"));
        contacts.put(ContactType.LINKEDIN, new Contact(ContactType.LINKEDIN, "gkislin"));
        contacts.put(ContactType.GITHUB, new Contact(ContactType.GITHUB, "gkislin"));
        contacts.put(ContactType.STACKOVERFLOW, new Contact(ContactType.STACKOVERFLOW, "548473"));
        contacts.put(ContactType.HOMEPAGE, new Contact(ContactType.HOMEPAGE, "http://gkislin.ru/"));

        Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
        sections.put(SectionType.OBJECTIVE, new StringSection(SectionType.OBJECTIVE, "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        sections.put(SectionType.PERSONAL, new StringSection(SectionType.PERSONAL, "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        List<String> list = new ArrayList<>();
        list.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        list.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        list.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        list.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        list.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        list.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        sections.put(SectionType.ACHIEVEMENT, new ListSection(SectionType.ACHIEVEMENT, list));

        list = new ArrayList<>();
        list.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        list.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        list.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        list.add("MySQL, SQLite, MS SQL, HSQLDB");
        list.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        list.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        list.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        list.add("Python: Django.");
        list.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        list.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        list.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        list.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        list.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        list.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        list.add("Родной русский, английский \"upper intermediate\"");

        sections.put(SectionType.QUALIFICATIONS, new ListSection(SectionType.QUALIFICATIONS, list));

        List<Place> places = new ArrayList<>();

        List<Period> periods = new ArrayList<>();
        periods.add(new Period("10/2013", null, "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        places.add(new Place("Java Online Projects", "http://javaops.ru/", periods));

        periods = new ArrayList<>();
        periods.add(new Period("10/2014", "01/2016", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        places.add(new Place("Wrike", "https://www.wrike.com/", periods));

        periods = new ArrayList<>();
        periods.add(new Period("04/2012", "10/2014", "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        places.add(new Place("RIT Center", null, periods));

        periods = new ArrayList<>();
        periods.add(new Period("12/2010", "04/2012", "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        places.add(new Place("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/", periods));

        periods = new ArrayList<>();
        periods.add(new Period("06/2008", "12/2010", "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        places.add(new Place("Yota", "https://www.yota.ru/", periods));

        periods = new ArrayList<>();
        periods.add(new Period("03/2007", "06/2008", "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));
        places.add(new Place("Enkata", "http://enkata.com/", periods));

        periods = new ArrayList<>();
        periods.add(new Period("01/2005", "02/2007", "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        places.add(new Place("Siemens AG", "https://www.siemens.com/ru/ru/home.html", periods));

        periods = new ArrayList<>();
        periods.add(new Period("09/1997", "01/2005", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));
        places.add(new Place("Alcatel", "http://www.alcatel.ru/", periods));

        sections.put(SectionType.EXPERIENCE, new PeriodSection(SectionType.EXPERIENCE, places));

        places = new ArrayList<>();

        periods = new ArrayList<>();
        periods.add(new Period("03/2013", "05/2013", "\"Functional Programming Principles in Scala\" by Martin Odersky", null));
        places.add(new Place("Coursera", "https://www.coursera.org/course/progfun", periods));

        periods = new ArrayList<>();
        periods.add(new Period("03/2011", "04/2011", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", null));
        places.add(new Place("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", periods));

        periods = new ArrayList<>();
        periods.add(new Period("01/2005", "04/2005", "3 месяца обучения мобильным IN сетям (Берлин)", null));
        places.add(new Place("Siemens AG", "http://www.siemens.ru/", periods));

        periods = new ArrayList<>();
        periods.add(new Period("09/1997", "03/1998", "6 месяцев обучения цифровым телефонным сетям (Москва)", null));
        places.add(new Place("Alcatel", "http://www.alcatel.ru/", periods));

        periods = new ArrayList<>();
        periods.add(new Period("09/1993", "07/1996", "Аспирантура (программист С, С++)", null));
        periods.add(new Period("09/1987", "07/1993", "Инженер (программист Fortran, C)", null));
        places.add(new Place("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/", periods));

        periods = new ArrayList<>();
        periods.add(new Period("09/1984", "06/1987", "Закончил с отличием", null));
        places.add(new Place("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/", periods));

        sections.put(SectionType.EDUCATION, new PeriodSection(SectionType.EDUCATION, places));

        Resume r = new Resume("Григорий Кислин");
        r.setContacts(contacts);
        r.setSections(sections);
    }
}
