package com.git.yml;

import com.git.array.MyLinkedList;

import java.util.Iterator;

/**
 * @author authorZhao
 * @date 2019/12/16
 */
public class YmlLinkedList extends MyLinkedList<Yml> {



    public String get(String key){
        String[] keys = getkey(key);
        Iterator<Yml> iterator = this.iterator();
        int i = 0;
        int j = 0;
        while ( iterator.hasNext()){
            j++;
            if(j>=this.size())return null;
            Yml next = iterator.next();
            if(next.getName().equals(keys[i])){

                if(j+1>=this.size())return null;
                Yml yml = get(j);
                if(yml.getLevel()==next.getLevel()){
                    return next.getValue();
                }else if(yml.getLevel()>next.getLevel()){
                    if(keys.length>i){
                        i++;
                        continue;
                    }
                  return null;
                }else{
                     i++;
                    continue;
                }
            }else{
                continue;
            }
        }
        return null;
    }

    private String[] getkey(String key){
        return key.split("\\.");
    }
}
