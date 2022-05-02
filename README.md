This is a Springboot Application

By default it will run on 9000

Run on IDE -
1. Import CodeBase
2. run maven clean install
3. Run as Application
4. Server should be up at port 9000

Run as java application -
1. Import CodeBase
2. Run maven clean install
3. Run executable jar at target folder (overbond-eng-test-0.0.1-SNAPSHOT)
4. Server should be up at port 9000

To Verify:
Hit URL  -> http://localhost:9000/health/ping

To Get Result for Amount Outstanding:
Hit URL  -> http://localhost:9000/amountOutstanding/get