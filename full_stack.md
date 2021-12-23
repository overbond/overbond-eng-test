# Coding Challenge (Full Stack Role)
The following is a coding challenge that will give us some insight into your coding and problem solving abilities.

## Challenge
You will be provided with a raw unstructured data file. In this file, the data is stored as tags across multiple lines and multiple lines span a single record. Specifically, every 10 lines constitute to a single record.
For instance, row 1 to 10 refers to one record, row 11 to 20 refers to another record and so forth

### Goal
To reach the goal of this challenge, the steps can be broken into the following:
1. Parse the given file, specifically only the following fields in the data file:

| Field Names | Details |
|-------------|----------|
| ISIN | a string prefixed with **ISn** |
| Amount Outstanding | a string prefixed with **AOs** |
| Maturity Date | a number sequence prefixed with **DMa** |

2. Group the parsed data by its maturity date's year then take the sum of each group's amount outstanding
3. Plot the sum of each year's amount outstanding as a bar graph

### Sample Input
| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| BDSr | i2 | NAmGITS |
| BDx | i138 | Si6 | s2 | SYmIS | NAmNasdaq Iceland hf. | CNyIS | MIcXICE |
| BDm | i896 | Si006178 | s2 | Ex138 | NAmIceland Cash Bond Trading | SYmICECB | TOTa+0000 | LDa20190406 | MIcXICE |
| BDIs | i15020 | SiRIK | s2 | ISsRIK | NAmRíkissjóður Íslands | CNyIS | MLEi254900IPCJWRC6XAJN15 |
| BDt | i2878286 | SiRIKS_26_0216 | s2 | Ex138 | Mk896 | INiRIK013ICECBCSH | SYmRIKS 26 0216 | NAmRíkissjóður 26 0216 | SNmRIKS 26 0216 | ISnIS0000030732 | ISi15020 | ISsRIK | CUiISK | CUtISK | PRt3 | VOd2 | LDa20181129 | Cf1 | TTd20260216 | CFcDBFTFR | IEtBullet loan | NMv1 | ITSz347 | NDp4 | NDc3 | MPmN | MPaN | NDTp4 | NDTc3 | CLId21232 | CNyIS | ITStN | SSc2 | STy4 | AUmY | TRaY | INrY | PTaN | PTb2 | OXCl0 | RLoY | IaN | FxN | IqN | TUsN | MSc449 | LSz1 |
| BDu | i2878286 | SiRIKS_26_0216 | s2 | IICtISIN | "FISnENDURLAN/1\ | 5 TB 20260216" | MIFrBOND | MCTyOTHR | MLIqN | MTcN | MLPr100000000 | MLPo0 | MSPo0 | MJCjN | MQu10000 | MBTyEUSB | MBPs0 | MCStN |
| BDBo | i2878286 | SiRIKS_26_0216 | s2 | BTy1 | DIs20180216 | AOs37879700000 | DMa20260216 | RCp1.5 | DNc20220216 | DCm5 | Mv100 | HaN | RDd0 | RDt1 | NRd2 | CPFrN | LCOd20260216 | Fv1 | CFq1 | Cc8 | RIxCPI_IS | FCd20190216 | VBa446.98571 | Vm1 | MDo255 | SSDaN | FIt3 | DAd20180216 |
| BDLi | i14702 | SiISTO | s2 | LSt433 | SYmISTO | NAmICE Inflation-linked Treasury Bonds | LCyISK | TCeY |
| BDLi | i14704 | SiICE_INFLATION-LINKED_TREASURY_BO | s2 | LSt434 | PAi14702 | NAmICE Inflation-linked Treasury Bonds | LCyISK | TCeN |
| m | i2878286 | t180000.355 | Dt20210827 | ISOcY | ISOtY | d0.035 | BPr106.45 | APl106.67 | Pl106.56 | Ph106.56 | LOp106.56 | Pd0.005 | q1 | o60000000 | Rq60000000 | HPm107.37 | HPMd20210803 | LPm106.4 | LPMd20210819 | HPy109.175 | HPYd20210429 | LPy106.4 | LPYd20210819 | LTd20210827 | LPd20210827 |
| BDSr | i2 | NAmGITS |
| BDx | i138 | Si6 | s2 | SYmIS | NAmNasdaq Iceland hf. | CNyIS | MIcXICE |
| BDm | i896 | Si006178 | s2 | Ex138 | NAmIceland Cash Bond Trading | SYmICECB | TOTa+0000 | LDa20190406 | MIcXICE |
| BDIs | i15020 | SiRIK | s2 | ISsRIK | NAmRíkissjóður Íslands | CNyIS | MLEi254900IPCJWRC6XAJN15 |
| BDt | i916698 | SiRIKS_30_0701 | s2 | Ex138 | Mk896 | INiRIK014ICECBCSH | SYmRIKS 30 0701 | NAmRíkissjóður 30 0701 | SNmRIKS 30 0701 | ISnIS0000020576 | ISi15020 | ISsRIK | CUiISK | CUtISK | PRt3 | VOd2 | LDa20110701 | Cf1 | TTd20300701 | CFcDBFTFR | IEtBullet loan | NMv1 | ITSz347 | NDp4 | NDc3 | MPmN | MPaN | NDTp4 | NDTc3 | CLId21232 | CNyIS | ITStN | SSc2 | STy4 | AUmY | TRaY | INrY | PTaN | PTb2 | OXCl0 | RLoY | IaN | FxN | IqN | TUsN | MSc449 | LSz1 |
| BDu | i916698 | SiRIKS_30_0701 | s2 | IICtISIN | FISnSEDLABANKI/3.25 BD 20300701 | MIFrBOND | MCTyOTHR | MLIqN | MTcN | MLPr100000000 | MLPo0 | MSPo0 | MJCjN | MQu10000 | MBTyEUSB | MBPs0 | MCStN |
| BDBo | i916698 | SiRIKS_30_0701 | s2 | BTy1 | DIs20110701 | AOs78683199659 | DMa20300701 | RCp3.25 | DNc20220701 | DCm5 | Mv100 | HaN | RDd0 | RDt1 | NRd2 | CPFrN | LCOd20300701 | Fv1 | CFq1 | Cc8 | RIxCPI_IS | FCd20120701 | VBa377.6 | Vm1 | MDo255 | SSDaN | FIt3 | DAd20110701 |
| BDLi | i14702 | SiISTO | s2 | LSt433 | SYmISTO | NAmICE Inflation-linked Treasury Bonds | LCyISK | TCeY |
| BDLi | i14704 | SiICE_INFLATION-LINKED_TREASURY_BO | s2 | LSt434 | PAi14702 | NAmICE Inflation-linked Treasury Bonds | LCyISK | TCeN |
| m | i916698 | t180000.353 | Dt20210827 | ISOcY | ISOtY | d0.05 | BPr122.95 | APl123.485 | Pl123.175 | HPm125.2 | HPMd20210803 | LPm123.175 | LPMd20210826 | HPy125.905 | HPYd20210113 | LPy122.93 | LPYd20210512 | LTd20210826 | LPd20210826 |
| BDSr | i2 | NAmGITS | 
| BDx | i138 | Si6 | s2 | SYmIS | NAmNasdaq Iceland hf. | CNyIS | MIcXICE |
| BDm | i896 | Si006178 | s2 | Ex138 | NAmIceland Cash Bond Trading | SYmICECB | TOTa+0000 | LDa20190406 | MIcXICE |
| BDIs | i15020 | SiRIK | s2 | ISsRIK | NAmRíkissjóður Íslands | CNyIS | MLEi254900IPCJWRC6XAJN15 |
| BDt | i3848464 | SiRIKV_21_1115 | s2 | Ex138 | Mk896 | INiRIK040ICECBCSH | SYmRIKV 21 1115 | NAmRíkissjóður Íslands 21 1115 | SNmRIKV 21 1115 | ISnIS0000032316 | ISi15020 | ISsRIK | CUiISK | CUtISK | PRt3 | VOd2 | LDa20210601 | Cf1 | TTd20211115 | CFcDYZTXR | IEtBill | NMv1 | ITSz347 | NDp4 | NDc3 | MPmN | MPaN | NDTp4 | NDTc3 | CLId21232 | CNyIS | ITStN | SSc2 | STy4 | AUmY | TRaY | INrY | PTaN | PTb2 | OXCl0 | RLoY | IaN | FxN | IqN | TUsN | MSc449 | LSz1 |
| BDu | i3848464 | SiRIKV_21_1115 | s2 | IICtISIN | FISnENDURLAN RIKISS/ZERO CPN B 20211115 | MIFrBOND | MCTyOTHR | MLIqN | MTcN | MLPr100000000 | MLPo0 | MSPo0 | MJCjN | MQu10000 | MBTyEUSB | MBPs0 | MCStN |
| BDBo | i3848464 | SiRIKV_21_1115 | s2 | BTy1 | DIs20210601 | AOs37700000000 | DMa20210915 | DCm3 | Mv100 | HaN | RDd0 | RDt1 | NRd2 | CPFrY | Fv1 | CFq0 | Cc8 | Vm1 | MDo255 | SSDaN | FIt1 |
| BDLi | i14710 | SiISTB | s2 | LSt433 | SYmISTB | NAmICE Treasury Bills | LCyISK | TCeY |
| BDLi | i14712 | SiICE_TREASURY_BILLS | s2 | LSt434 | PAi14710 | NAmICE Treasury Bills | LCyISK | TCeN |
| m | i3848464 | t180000.356 | Dt20210827 | ISOcY | ISOtY | d0.01 | BPr99.625 |
| BDSr | i2 | NAmGITS | 
| BDx | i138 | Si6 | s2 | SYmIS | NAmNasdaq Iceland hf. | CNyIS | MIcXICE |
| BDm | i896 | Si006178 | s2 | Ex138 | NAmIceland Cash Bond Trading | SYmICECB | TOTa+0000 | LDa20190406 | MIcXICE |
| BDIs | i15020 | SiRIK | s2 | ISsRIK | NAmRíkissjóður Íslands | CNyIS | MLEi254900IPCJWRC6XAJN15 |
| BDt | i3848464 | SiRIKV_21_1115 | s2 | Ex138 | Mk896 | INiRIK040ICECBCSH | SYmRIKV 21 1115 | NAmRíkissjóður Íslands 21 1115 | SNmRIKV 21 1115 | ISnIS0000031345 | ISi15020 | ISsRIK | CUiISK | CUtISK | PRt3 | VOd2 | LDa20210601 | Cf1 | TTd20211115 | CFcDYZTXR | IEtBill | NMv1 | ITSz347 | NDp4 | NDc3 | MPmN | MPaN | NDTp4 | NDTc3 | CLId21232 | CNyIS | ITStN | SSc2 | STy4 | AUmY | TRaY | INrY | PTaN | PTb2 | OXCl0 | RLoY | IaN | FxN | IqN | TUsN | MSc449 | LSz1 |
| BDu | i3848464 | SiRIKV_21_1115 | s2 | IICtISIN | FISnENDURLAN RIKISS/ZERO CPN B 20211115 | MIFrBOND | MCTyOTHR | MLIqN | MTcN | MLPr100000000 | MLPo0 | MSPo0 | MJCjN | MQu10000 | MBTyEUSB | MBPs0 | MCStN |
| BDBo | i3848464 | SiRIKV_21_1115 | s2 | BTy1 | DIs20210601 | AOs20500000000 | DMa20211001 | DCm3 | Mv100 | HaN | RDd0 | RDt1 | NRd2 | CPFrY | Fv1 | CFq0 | Cc8 | Vm1 | MDo255 | SSDaN | FIt1 |
| BDLi | i14710 | SiISTB | s2 | LSt433 | SYmISTB | NAmICE Treasury Bills | LCyISK | TCeY |
| BDLi | i14712 | SiICE_TREASURY_BILLS | s2 | LSt434 | PAi14710 | NAmICE Treasury Bills | LCyISK | TCeN |
| m | i3848464 | t180000.356 | Dt20210827 | ISOcY | ISOtY | d0.01 | BPr99.625 |

### Sample Output
This is what the parsed data along with the bar graph should look like:
| ISIN | Amount Outstanding | Maturity Date |
|---|---|---|
| IS0000030732 | 37879700000 | 2026-02-16 |
| IS0000020576 | 78683199659 | 2030-07-01 |
| IS0000032316 | 37700000000 | 2021-09-15 |
| IS0000031345 | 20500000000 | 2021-10-01 |

![](/assets/full_stack_graph.png)

## Technical Spec
Use any language and any visualization tool which you are most comfortable with. Overbond is a Rails shop, so if you can write the solution in Ruby, great! But it's not required. **The allocated time is ~ 1 day.**

Please organize, design, test and document your code as if it were going into production. Write your README as if it was for a production service and include the following items:

* Reasoning behind your technical choices
* Trade-offs you might have made or what you might do differently if you were to spend additional time on the project 

## How we review
Remember, this is production level code. The aspects of your code we will judge include:

* **Functionality**: Does the application do what was asked?
* **Choice of visualization tool**: Does the chosen tool does what it's supposed to do?
* **Code quality**: Is the code simple and easy to understand? Is the code modularized? Are there meaningful comments added?
* **Testing**: Are there automated tests? Do they provide sufficient coverage?
* **Documentation**: Is a README file included? Does it specify how to execute the app? Does it describe your approach sufficiently?

## Submission
Email us a zip file containing your solution or send us your solution's GitHub repo link