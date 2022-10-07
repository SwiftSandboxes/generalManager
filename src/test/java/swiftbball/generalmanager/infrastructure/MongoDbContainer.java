package swiftbball.generalmanager.infrastructure;

import org.jetbrains.annotations.NotNull;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;

public class MongoDbContainer extends GenericContainer<MongoDbContainer> {

    public static final Network NETWORK = Network.newNetwork();
    public static final String DEFAULT_IMAGE_AND_TAG = "mongo:4.2.6";
    public static final int DEFAULT_PORT = 27017;

    public MongoDbContainer() {
        super(DEFAULT_IMAGE_AND_TAG);
        withNetwork(NETWORK).withExposedPorts(DEFAULT_PORT);
    }

    @NotNull
    public Integer getPort() {
        return getMappedPort(DEFAULT_PORT);
    }
}
