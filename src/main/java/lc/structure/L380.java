package main.java.lc.structure;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20231204
 **/
@Slf4j
public class L380 {



    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        log.info("res:{}",randomizedSet.insert(1));
        log.info("res:{}",randomizedSet.insert(10));
        log.info("res:{}",randomizedSet.insert(20));
        log.info("res:{}",randomizedSet.insert(30));
        log.info("res:{}",randomizedSet.getRandom());
        log.info("res:{}",randomizedSet.getRandom());
        log.info("res:{}",randomizedSet.getRandom());
        log.info("res:{}",randomizedSet.getRandom());
        log.info("res:{}",randomizedSet.getRandom());
    }


    static class RandomizedSet {

        private List<Integer> vals;
        private Map<Integer, Integer> valMap;



        public RandomizedSet() {
            vals = new ArrayList<>();
            valMap = new HashMap<>();
        }

        public boolean insert(int val) {
            Integer tmp = valMap.getOrDefault(val, null);
            if (tmp != null) {
                return false;
            }
            valMap.put(val, vals.size());
            vals.add(val);
            return true;
        }

        public boolean remove(int val) {
            Integer tmp = valMap.getOrDefault(val, null);
            if (tmp == null) {
                return false;
            }
            vals.set(tmp, vals.get(vals.size()-1));
            valMap.put(vals.get(vals.size()-1), tmp);
            vals.remove(vals.size()-1);
            valMap.put(val, null);
            return true;
        }

        public int getRandom() {
            return vals.get((int)(Math.random()*vals.size()));
        }
    }


}
