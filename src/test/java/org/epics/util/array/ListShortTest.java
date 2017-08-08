/**
 * Copyright (C) 2010-14 diirt developers. See COPYRIGHT.TXT
 * All rights reserved. Use is subject to license terms. See LICENSE.TXT
 */
package org.epics.util.array;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author carcassi
 */
public class ListShortTest extends ListNumberTestBase<ListShort> {

    public ListShortTest() {
        super(new ListShort() {

            @Override
            public int size() {
                return 10;
            }

            @Override
            public short getShort(int index) {
                return 1;
            }
        },
        new ListShort() {

            @Override
            public int size() {
                return 10;
            }

            @Override
            public short getShort(int index) {
                return (short) index;
            }
        },
        new ArrayShort(new short[] {0,1,2,3,4,5,6,7,8,9}));
    }

    @Test
    public void toString1() {
        assertThat(incrementCollection.toString(), equalTo("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"));
    }

    @Test
    public void serialization1() throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(buffer);
        ArrayShort array = new ArrayShort(new short[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        stream.writeObject(array);
        ObjectInputStream inStream = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
        ArrayShort read = (ArrayShort) inStream.readObject();
        assertThat(read, not(sameInstance(array)));
        assertThat(read, equalTo(array));
    }

}
