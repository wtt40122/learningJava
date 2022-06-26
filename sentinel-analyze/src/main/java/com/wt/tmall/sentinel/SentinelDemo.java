package com.wt.tmall.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author: wtt
 * @date: 2022/5/29 16:44
 * @description:
 */
public class SentinelDemo {

    private void doBusiness() {

    }

    public static void main(String[] args) throws BlockException {
        ContextUtil.enter("myTest");
        Entry entry = null;
        try {
            entry = SphU.entry("myResource", EntryType.IN);
        } catch (Exception e) {
            if (!(e instanceof BlockException)) {
                Tracer.trace(e);
            }
            throw e;
        } finally {
            if (null != entry) {
                entry.exit(1);
            }
            ContextUtil.exit();
        }
    }
}
