package com.qdz.proxy.asm.test1;


import com.qdz.proxy.asm.MyClassLoader;
import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author authorZhao
 * @date 2019/12/30
 */
public class UserImplUtils {

    /**
     * 根据类全名和接口名生成class文件
     * @param className 类全名，注意是用点分隔的，采用idea的
     * @param clazz 接口class对象 采用点分隔
     * @return
     * @throws Exception
     */
    private static byte[] dump(String className,Class clazz) throws Exception {
        String className2 = className.replace(".","/");
        String sourceName = className.substring(className.lastIndexOf(".")+1)+".java";
        //模仿常量池的语法
        String constClassName = "L"+className2+";";//Lcom/qdz/proxy/asm/test1/UserImpl;

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;
        //声明需要实现的类
        //jdk版本 11,权限，这个不懂，类名，签名，父类名，接口名
        cw.visit(55, ACC_PUBLIC + ACC_SUPER, className2, null, "java/lang/Object", new String[]{clazz.getName().replace(".","/")});
        //
        cw.visitSource(sourceName, null);

        //设置属性 name
        // age
        {
            fv = cw.visitField(ACC_PRIVATE, "name", "Ljava/lang/String;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "age", "Ljava/lang/Integer;", null, null);
            fv.visitEnd();
        }
        //方法
        {
            //构造方法，语法固定
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(7, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            //这个this是固定写法
            mv.visitLocalVariable("this", constClassName, null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        //getName方法
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/String;", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(14, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, className2, "name", "Ljava/lang/String;");
            mv.visitInsn(ARETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", constClassName, null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        //setName方法
        {
            mv = cw.visitMethod(ACC_PUBLIC, "setName", "(Ljava/lang/String;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(18, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, className2, "name", "Ljava/lang/String;");
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(19, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", constClassName, null, l0, l2, 0);
            mv.visitLocalVariable("name", "Ljava/lang/String;", null, l0, l2, 1);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        //getAge方法
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getAge", "()Ljava/lang/Integer;", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(22, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, className2, "age", "Ljava/lang/Integer;");
            mv.visitInsn(ARETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", constClassName, null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        //setAge方法
        {
            mv = cw.visitMethod(ACC_PUBLIC, "setAge", "(Ljava/lang/Integer;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(26, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, className2, "age", "Ljava/lang/Integer;");
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(27, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", constClassName, null, l0, l2, 0);
            mv.visitLocalVariable("age", "Ljava/lang/Integer;", null, l0, l2, 1);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    /**
     * 根据类名和接口返回对应的class对象
     * @param className 类全名，注意是用点分隔的，采用idea的
     * @param clazz 接口class对象 采用点分隔
     * @return
     * @throws Exception
     */
    public static Class<?> getClass(String className,Class clazz ) throws Exception {
        byte[] classData = dump(className, clazz);
        return  new MyClassLoader().defineClassForName(className, classData);
    }
}
