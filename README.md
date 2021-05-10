gatling-demo
=========================

Simple showcase of a maven project using the gatling-maven-plugin.

Before testing, you will need to run the following docker compose:

    $docker compose up

To test it out, simply execute the following command:

    $mvn gatling:test -Dgatling.simulationClass=com.serrodcal.FruitSimulation

or simply:

    $mvn gatling:test

## Exporting metrics to Grafana

Before testing, you will need to run the following docker compose:

    $docker compose -f docker-compose-all-in-one.yml up

Then, configure `graphite` in `src/test/resources/gatling.conf` and uncomment the following lines as is given below:

    ```
    data {
        writers = [console, file, graphite]      # The list of DataWriters to which Gatling write simulation data (currently supported : console, file, graphite)
        console {
          #light = false                # When set to true, displays a light version without detailed request stats
          #writePeriod = 5              # Write interval, in seconds
        }
        file {
          #bufferSize = 8192            # FileDataWriter's internal data buffer size, in bytes
        }
        leak {
          #noActivityTimeout = 30  # Period, in seconds, for which Gatling may have no activity before considering a leak may be happening
        }
        graphite {
          #light = false              # only send the all* stats
          host = "localhost"         # The host where the Carbon server is located
          port = 2003                # The port to which the Carbon server listens to (2003 is default for plaintext, 2004 is default for pickle)
          protocol = "tcp"           # The protocol used to send data to Carbon (currently supported : "tcp", "udp")
          #rootPathPrefix = "gatling" # The common prefix of all metrics sent to Graphite
          #bufferSize = 8192          # Internal data buffer size, in bytes
          #writePeriod = 1            # Write period, in seconds
        }
    }
    ```

Finally, start the test:

    $mvn gatling:test
