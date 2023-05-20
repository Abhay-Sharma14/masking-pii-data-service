package com.masking.pii.data.encrypt;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ProtectDataSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        String pii = value.toString().replaceAll("\\w(?=\\w{4})", "x");
        gen.writeString(pii);
    }
}
