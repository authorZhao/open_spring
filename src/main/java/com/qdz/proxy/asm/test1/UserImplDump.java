package com.qdz.proxy.asm.test1;

import com.qdz.proxy.asm.MyClassLoader;
import org.objectweb.asm.*;

import java.lang.reflect.Method;

/**
 * @author authorZhao
 * @date 2019/12/30
 */
public class UserImplDump implements Opcodes {

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "com/qdz/proxy/asm/test1/UserImpl", null, "java/lang/Object", new String[]{"com/qdz/proxy/asm/test1/User"});

        cw.visitSource("UserImpl.java", null);

        {
            fv = cw.visitField(ACC_PRIVATE, "name", "Ljava/lang/String;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "age", "Ljava/lang/Integer;", null, null);
            fv.visitEnd();
        }
        {
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
            mv.visitLocalVariable("this", "Lcom/qdz/proxy/asm/test1/UserImpl;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/String;", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(14, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "com/qdz/proxy/asm/test1/UserImpl", "name", "Ljava/lang/String;");
            mv.visitInsn(ARETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lcom/qdz/proxy/asm/test1/UserImpl;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "setName", "(Ljava/lang/String;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(18, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "com/qdz/proxy/asm/test1/UserImpl", "name", "Ljava/lang/String;");
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(19, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "Lcom/qdz/proxy/asm/test1/UserImpl;", null, l0, l2, 0);
            mv.visitLocalVariable("name", "Ljava/lang/String;", null, l0, l2, 1);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getAge", "()Ljava/lang/Integer;", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(22, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "com/qdz/proxy/asm/test1/UserImpl", "age", "Ljava/lang/Integer;");
            mv.visitInsn(ARETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lcom/qdz/proxy/asm/test1/UserImpl;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "setAge", "(Ljava/lang/Integer;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(26, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "com/qdz/proxy/asm/test1/UserImpl", "age", "Ljava/lang/Integer;");
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(27, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "Lcom/qdz/proxy/asm/test1/UserImpl;", null, l0, l2, 0);
            mv.visitLocalVariable("age", "Ljava/lang/Integer;", null, l0, l2, 1);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    public static void main(String[] args) {

        try {
            byte[] classData = dump();
            Class<?> clazz = new MyClassLoader().defineClassForName("com.qdz.proxy.asm.test1.UserImpl", classData);
            User user = (User)clazz.getConstructors()[0].newInstance();
            user.setName("渣渣辉");
            user.setAge(18);
            System.out.println("带噶好，我系"+user.getName()+",我今天"+user.getAge()+"岁");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
