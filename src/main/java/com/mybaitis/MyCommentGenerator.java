package com.mybaitis;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * @author ganyy
 * @version 1.0.0
 *          Create Date: 2017/4/1 9:33
 */
public class MyCommentGenerator implements CommentGenerator {

    public void addConfigurationProperties(Properties properties) {

    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");

        field.addAnnotation("@Column(length = "+introspectedColumn.getLength()+")");
        if (introspectedColumn.getActualColumnName().equalsIgnoreCase("id")) {
            field.addAnnotation("@Id");;
        }
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        StringBuilder sb = new StringBuilder();

        topLevelClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append(" ");
        sb.append(introspectedTable.getRemarks());
        topLevelClass.addJavaDocLine(sb.toString());

        sb.setLength(0);
        sb.append(" * @author ");
        sb.append("ganyy");
        sb.append(" ");
        sb.append("\n * @version 1.0.0 ");
        sb.append("create date: ");
        sb.append(LocalDate.now());

        topLevelClass.addJavaDocLine(sb.toString());
        topLevelClass.addJavaDocLine(" */");

        topLevelClass.addAnnotation("@Entity");
        topLevelClass.addAnnotation("@Getter");
        topLevelClass.addAnnotation("@Setter");
        topLevelClass.addAnnotation("@Table(name = \""+introspectedTable.getFullyQualifiedTable()+"\")");
        Set<FullyQualifiedJavaType> importedTypes = new HashSet<>();
        importedTypes.add(new FullyQualifiedJavaType("lombok.Getter"));
        importedTypes.add(new FullyQualifiedJavaType("lombok.Setter"));
        importedTypes.add(new FullyQualifiedJavaType("javax.persistence.Column"));
        importedTypes.add(new FullyQualifiedJavaType("javax.persistence.Entity"));
        importedTypes.add(new FullyQualifiedJavaType("javax.persistence.Id"));
        importedTypes.add(new FullyQualifiedJavaType("javax.persistence.Table"));
        topLevelClass.addImportedTypes(importedTypes);
    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {

    }

    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    }

    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    public void addJavaFileComment(CompilationUnit compilationUnit) {

    }

    public void addComment(XmlElement xmlElement) {

    }

    public void addRootComment(XmlElement xmlElement) {

    }
}
