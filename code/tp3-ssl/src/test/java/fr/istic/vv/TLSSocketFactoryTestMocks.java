package fr.istic.vv;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TLSSocketFactoryTestMocks {
    @Mock
    private SSLSocket sslSocketMock;

    private TLSSocketFactory tlsSocketFactory;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        tlsSocketFactory = new TLSSocketFactory();
    }

    @Test
    public void preparedSocket_NullProtocols() {
        when(sslSocketMock.getSupportedProtocols()).thenReturn(null);
        when(sslSocketMock.getEnabledProtocols()).thenReturn(null);

        try {
            tlsSocketFactory.prepareSocket(sslSocketMock);
            fail();
        }
        catch(Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void typical() {
        String[] supportedProtocols = { "SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" };
        String[] enabledProtocols = { "SSLv3", "TLSv1" };

        when(sslSocketMock.getSupportedProtocols()).thenReturn(shuffle(supportedProtocols));
        when(sslSocketMock.getEnabledProtocols()).thenReturn(shuffle(enabledProtocols));

        tlsSocketFactory.prepareSocket(sslSocketMock);

        /* Vérifie que setEnabledProtocols a été appelé (ici par prepareSocket) une fois
         * avec comme paramètre new String[] { "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }
         */
        verify(sslSocketMock).setEnabledProtocols(new String[] { "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" });
    }

    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}