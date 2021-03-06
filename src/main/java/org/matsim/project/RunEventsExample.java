// This is an event manager
package org.matsim.project; // Adjust for your project structure

import org.matsim.api.core.v01.network.Network;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsReaderXMLv1;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.io.MatsimNetworkReader;
//import org.matsim.core.network.io.NetworkReaderMatsimV1;

public class RunEventsExample {

    public static void main(String[] args) {
        EventsManager manager = EventsUtils.createEventsManager();

		manager.addHandler(new MyEventHandler1());

		Network network = NetworkUtils.createNetwork();
		MatsimNetworkReader reader = new MatsimNetworkReader(network);
		reader.readFile("output/output_network.xml.gz");
		manager.addHandler(new CongestionDetectionEventHandler(network));

        EventsReaderXMLv1 eventsReader = new EventsReaderXMLv1(manager);
        eventsReader.readFile("output/output_events.xml.gz");
    }
}
