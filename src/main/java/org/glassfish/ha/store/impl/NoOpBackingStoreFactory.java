/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.ha.store.impl;

import org.glassfish.ha.store.api.*;
import org.jvnet.hk2.annotations.Service;

import java.io.Serializable;

/**
 * @author Mahesh Kannan
 */
@Service(name="noop")
public class NoOpBackingStoreFactory
    implements BackingStoreFactory {

    private static BackingStoreTransaction _noOpTransaction = new BackingStoreTransaction() {
        public void commit() {}
    };

    public <K extends Serializable, V extends Serializable> BackingStore<K, V> createBackingStore(
            BackingStoreConfiguration<K, V> conf)
                throws BackingStoreException {
        NoOpBackingStore<K, V> store =  new NoOpBackingStore<K, V>();
        store.initialize(conf);

        return store;
    }

    public BackingStoreTransaction createBackingStoreTransaction() {
        return _noOpTransaction;
    }
}
