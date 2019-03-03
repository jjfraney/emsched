package org.jjfflyboy.em.scheduler.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author jfraney
 */
public class MinisterJsonTest {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void testRead() throws IOException {
        String in = "{\"firstName\":\"sam\",\"lastName\":\"Jones\"}";
        Minister minister = objectMapper.readValue(in, Minister.class);
        Assert.assertEquals("should have the right first name", "sam", minister.getFirstName());
    }

    @Test
    public void roundTripTest() throws IOException {
        Minister sam = new Minister();
        sam.setFirstName("Sam");
        sam.setLastName("Johnson");

        String out = objectMapper.writeValueAsString(sam);
        Minister sam2 = objectMapper.readValue(out, Minister.class);

        Assert.assertEquals("sam is not the same as before", sam, sam2);
    }
}
