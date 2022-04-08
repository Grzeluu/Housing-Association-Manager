package com.grzeluu.housingassociationmanager.data.model

class FakeData {
    companion object {
        val fakeFlats = listOf(
            FlatResponse(
                1,
                "Waszczyka",
                "51Z",
                "67-102",
                "Zielona Góra",
                "patrykg"
            ),
            FlatResponse(
                1,
                "Borowieckiego",
                "7C",
                "67-102",
                "Poznań",
                "patrykg"
            ),
            FlatResponse(
                1,
                "Hipolita",
                "54B",
                "67-102",
                "Warszawa",
                "patrykg"
            )
        )

        val fakeBillings = listOf(
            BillingResponse(
                1,
                12,
                "Marzec 2021",
                "2021-03-01",
                "2021-03-31",
                21.54,
                56.56,
                66.78,
                -64.18,
                false,
                "patrykg"
            ),
            BillingResponse(
                1,
                13,
                "Luty 2021",
                "2021-02-01",
                "2021-02-28",
                77.54,
                -21.56,
                89.78,
                23.18,
                true,
                "patrykg"
            ), BillingResponse(
                1,
                2,
                "Styczeń 2021",
                "2021-01-01",
                "2021-01-31",
                34.65,
                98.56,
                32.78,
                123.18,
                true,
                "patrykg"
            )
        )
    }
}