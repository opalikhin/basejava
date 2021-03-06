package com.opalikhin.webapp;

import com.opalikhin.webapp.model.*;
import com.opalikhin.webapp.util.DateUtil;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r = createTestResume(null);
        showTestResume(r);
    }

    public static Resume createTestResume(String uuid) {
        Resume r;
        if (uuid != null) {
            r = new Resume(uuid,"Григорий Кислин");
        } else {
            r = new Resume("Григорий Кислин");
        }

        Map<ContactType, String> contacts = r.getContacts();

        contacts.put(ContactType.PHONE, "+7(921) 855-0482");
        contacts.put(ContactType.SKYPE, "grigory.kislin");
        contacts.put(ContactType.EMAIL, "gkislin@yandex.ru");
        contacts.put(ContactType.LINKEDIN, "gkislin");
        contacts.put(ContactType.GITHUB, "gkislin");
        contacts.put(ContactType.STACKOVERFLOW, "548473");
        contacts.put(ContactType.HOMEPAGE, "http://gkislin.ru/");

        Map<SectionType, AbstractSection> sections = r.getSections();

        sections.put(SectionType.OBJECTIVE, new StringSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        sections.put(SectionType.PERSONAL, new StringSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        List<String> list = new ArrayList<>();
        list.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        list.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        list.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        list.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        list.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        list.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        sections.put(SectionType.ACHIEVEMENT, new ListSection(list));

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

        sections.put(SectionType.QUALIFICATIONS, new ListSection(list));

        List<Organization> organizations = new ArrayList<>();
        organizations.add(new Organization("Java Online Projects", "http://javaops.ru/", DateUtil.of(2013, Month.OCTOBER), null, "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        organizations.add(new Organization("Wrike", "https://www.wrike.com/", DateUtil.of(2014, Month.OCTOBER), DateUtil.of(2016, Month.JANUARY), "Старший разработчик (backend).", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        organizations.add(new Organization("RIT Center", null, DateUtil.of(2012, Month.APRIL), DateUtil.of(2014, Month.OCTOBER), "Java архитектор.", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        organizations.add(new Organization("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/", DateUtil.of(2010, Month.DECEMBER), DateUtil.of(2012, Month.APRIL), "Ведущий программист.", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        organizations.add(new Organization("Yota", "https://www.yota.ru/", DateUtil.of(2008, Month.JUNE), DateUtil.of(2010, Month.DECEMBER), "Ведущий специалист.", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        organizations.add(new Organization("Enkata", "http://enkata.com/", DateUtil.of(2007, Month.MARCH), DateUtil.of(2008, Month.JUNE), "Разработчик ПО.", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));
        organizations.add(new Organization("Siemens AG", "https://www.siemens.com/ru/ru/home.html", DateUtil.of(2005, Month.JANUARY), DateUtil.of(2007, Month.FEBRUARY), "Разработчик ПО.", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        organizations.add(new Organization("Alcatel", "http://www.alcatel.ru/", DateUtil.of(1997, Month.SEPTEMBER), DateUtil.of(2005, Month.JANUARY), "Инженер по аппаратному и программному тестированию.", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));
        sections.put(SectionType.EXPERIENCE, new OrganizationSection(organizations));

        organizations = new ArrayList<>();
        organizations.add(new Organization("Coursera", "https://www.coursera.org/course/progfun", DateUtil.of(2013, Month.MARCH), DateUtil.of(2013, Month.MAY), "\"Functional Programming Principles in Scala\" by Martin Odersky", null));
        organizations.add(new Organization("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", DateUtil.of(2011, Month.MARCH), DateUtil.of(2011, Month.APRIL), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", null));
        organizations.add(new Organization("Siemens AG", "http://www.siemens.ru/", DateUtil.of(2005, Month.JANUARY), DateUtil.of(2005, Month.APRIL), "3 месяца обучения мобильным IN сетям (Берлин)", null));
        organizations.add(new Organization("Alcatel", "http://www.alcatel.ru/", DateUtil.of(1997, Month.SEPTEMBER), DateUtil.of(1998, Month.MARCH), "6 месяцев обучения цифровым телефонным сетям (Москва)", null));

        Organization organization = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/", DateUtil.of(1993, Month.SEPTEMBER), DateUtil.of(1996, Month.JULY), "Аспирантура (программист С, С++)", null);
        organization.getPositions().add(new Position(DateUtil.of(1987, Month.SEPTEMBER), DateUtil.of(1993, Month.JULY), "Инженер (программист Fortran, C)", null));
        organizations.add(organization);

        organizations.add(new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/", DateUtil.of(1984, Month.SEPTEMBER), DateUtil.of(1987, Month.JUNE), "Закончил с отличием", null));
        sections.put(SectionType.EDUCATION, new OrganizationSection(organizations));
        return r;
    }

    private static void showTestResume(Resume r) {
        System.out.printf("uuid: %s%n", r.getUuid());
        System.out.printf("FullName: %s%n", r.getFullName());
        System.out.println("CONTACTS");
        for (ContactType t : ContactType.values()) {
            System.out.printf("  %s: %s%n", t.getTitle(), r.getContacts().get(t));
        }
        System.out.println("SECTIONS");
        for (SectionType s : SectionType.values()) {
            System.out.printf("  %s: %n%s%n", s.getTitle(), r.getSections().get(s).toString());
        }
    }
}
