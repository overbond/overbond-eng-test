# Coding Challenge (Director Role)
The following is a coding challenge that will give us some insight into your coding and problem solving abilities.

## Challenge
You will be provided with a raw unstructured data file. In this file, the data is stored as tags across multiple lines and multiple lines span a single record. Specifically, every 10 lines constitutes to a single record. For instance, row 1 to 10 refers to one record, row 11 to 20 refers to another record and so forth.

### Goal
The goal of this challenge is to parse the given file and store the parsed data into **any** SQL database of your choice (**Please make sure you also include your database schema design as part of your solution**).

The following are the details of the fields that you are required to parse/extract from the given data file:

| Field Names | Details |
| ----------- | ------- |
| ISIN | a string prefixed with **ISn** |
| DataDATE | a string prefixed with **Dt** |
| Name | a string prefixed with **NAm** in third last or second last of the block | 
| Trading Type | a string prefixed with **NAm** in third row of the block |
| RIKS | a string prefixed with **SNm** | 
| Issue Currency | a string prefixed with **CUi** | 
| Trading Currency | a string prefixed with **CUt** |
| Last trading Day | a number sequence prefixed with **TTd** |
| Issuance Date | a string prefixed wtih **DIs** |
| Amount Outstanding | a string prefixed with **AOs** |
| Coupon Rate | a string prefixed with **RCp** |
| Maturity Date | a number sequence prefixed with **DNc** |
| Reddem Value | a number prefixed with **Mv** |
| Last Coupon Date | a number sequence prefixed with **LCOd** |
| Next Coupon Date | a number sequence prefixed with **DNc** |
| Number of Coupons | a number prefixed with **CFq** |
| Base Value | a number prefixed with **VBa** | 
| CleanBid | a number prefixed with **BPr** | 
| CleanAsk | a number prefixed with **APl** |
| Last Price | a number prefixed with **Pl** |

### Sample Input
The following shows what the parsed data should look like:

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

### Sample Output
| ISIN | DataDATE | Name | Trading Type | RIKS | Issue Currency | Trading Currency | Last trading Day | Issuance Date | Amount Outstanding | Coupon Rate | Maturity Date | Reddem Value | Last Coupon Date | Next Coupon Date | Number of Coupons | Base Value | CleanBid | CleanAsk | Last Price |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
IS0000030732 | 2021-08-27 | ICE Inflation-linked Treasury Bonds | Iceland Cash Bond Trading | RIKS 26 0216 | ISK | ISK | 2026-02-16 | 2018-02-16 | 37879700000 | 1.5 | 2022-02-16 | 100 | 2026-02-16 | 2022-02-16 | 1 | 446.98571 | 106.45 | 106.67 | 106.56 |

## Technical Spec
Use any lanaguage which you are most comfortable with.
Overbond is a Rails shop, so if you can write the solution in Ruby, great! But it's not required. You're also welcome to design the database however you like. **The allocated time is ~ 2 days.**

Please organize, design, test and document your code as if it were going into production. Write your README as if it was for a production service and include the following items:

* Reasoning behind your technical choices
* Trade-offs you might have made or what you might do differently if you were to spend additional time on the project

## How we review
Remember, this is production level code. The aspects of your code we will judge include:

* **Functionality**: Does the application do what was asked?
* **Database Design**: Does the database design make sense?
* **Code quality**: Is the code simple and easy to understand? Is the code modularized? Are there meaningful comments added?
* **Testing**: Are there automated tests? Do they provide sufficient coverage?
* **Documentation**: Is a README file included? Does it specify how to execute the app? Does it describe your approach sufficiently?

## Submission
Email us a zip file or a GitHub repo link containing your solution and your **database schema design**