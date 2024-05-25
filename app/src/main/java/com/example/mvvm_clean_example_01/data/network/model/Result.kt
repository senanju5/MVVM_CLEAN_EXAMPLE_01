package com.example.mvvm_clean_example_01.data.network.model


import com.google.gson.annotations.SerializedName

data class Result(

    @SerializedName("id")
    val id: Int, // 716406
    @SerializedName("image")
    val image: String, // https://img.spoonacular.com/recipes/716406-312x231.jpg
    @SerializedName("imageType")
    val imageType: String, // jpg
    @SerializedName("pricePerServing")
    val pricePerServing: Double, // 178.37
    @SerializedName("servings")
    val servings: Int, // 2
    @SerializedName("sourceName")
    val sourceName: String, // Full Belly Sisters
    @SerializedName("summary")
    val summary: String, // Asparagus and Pea Soup: Real Convenience Food requires approximately <b>20 minutes</b> from start to finish. Watching your figure? This gluten free, dairy free, paleolithic, and lacto ovo vegetarian recipe has <b>217 calories</b>, <b>11g of protein</b>, and <b>8g of fat</b> per serving. This recipe serves 2. For <b>$1.78 per serving</b>, this recipe <b>covers 25%</b> of your daily requirements of vitamins and minerals. <b>Autumn</b> will be even more special with this recipe. It works well as a hor d'oeuvre. 207 people have tried and liked this recipe. It is brought to you by fullbellysisters.blogspot.com. A mixture of vegetable broth, evoo, garlic, and a handful of other ingredients are all it takes to make this recipe so yummy. All things considered, we decided this recipe <b>deserves a spoonacular score of 96%</b>. This score is outstanding. Try <a href="https://spoonacular.com/recipes/asparagus-and-pea-soup-real-convenience-food-1393979">Asparagus and Pea Soup: Real Convenience Food</a>, <a href="https://spoonacular.com/recipes/asparagus-and-pea-soup-real-convenience-food-1376201">Asparagus and Pea Soup: Real Convenience Food</a>, and <a href="https://spoonacular.com/recipes/asparagus-and-pea-soup-real-convenience-food-1362341">Asparagus and Pea Soup: Real Convenience Food</a> for similar recipes.
    @SerializedName("title")
    val title: String, // Asparagus and Pea Soup: Real Convenience Food

)