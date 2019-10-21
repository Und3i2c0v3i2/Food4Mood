package com.example.food_for_mood.service.database;



import com.example.food_for_mood.service.model.Category;
import com.example.food_for_mood.service.model.Recipe;

import java.util.Arrays;

class MockData {


    static Recipe[] initializeRecipes() {

        return new Recipe[] {

                new Recipe("Peruvian chicken, avocado & quinoa salad",
                        "Fed up with pasta salad? This gluten-free alternative is packed with lean protein from the chicken, and healthy, heart-friendly fats from the avocado",
                        3,
                        Arrays.asList("50g uncooked quinoa",
                                "100g frozen sweetcorn",
                                "1 tbsp extra virgin olive oil",
                                "75g cherry tomatoes, quartered",
                                "small pack coriander, leaves roughly chopped",
                                "2 spring onions, trimmed and finely sliced",
                                "zest and juice 1 lime",
                                "½ long red chilli, finely chopped (deseeded if you don’t like it too hot)",
                                "1 ripe but firm avocado",
                                "200g skinless, cold, cooked roast chicken, cut into chunky pieces"),
                        "Half-fill a medium pan with water and bring to the boil. Rinse the quinoa in a fine sieve, then add to the water, stir well and simmer for 12 mins or until just tender.\n" +
                                "\nWhile the quinoa is cooking, put the sweetcorn in a dry frying pan over a medium-high heat. Cook for 5 mins, turning every now and then, until defrosted and lightly toasted. Set aside.\n" +
                                "\nRinse the cooked quinoa in a sieve under cold water, then press hard with a serving spoon to remove excess water.\n" +
                                "\nTip the quinoa into a bowl and toss with the olive oil, sweetcorn, tomatoes, coriander, spring onions, lime zest and chilli. Season well with black pepper.\n" +
                                "\nHalve and stone the avocado. Scoop out the flesh with a large metal spoon, cut into slices and combine with the lime juice. Add the chicken pieces and avocado to the salad and toss gently together before serving.",
                        512,
                        "peruvian_chicken_avocado_quinoa_salad.jpg",
                        4.3f, false, 3),

                new Recipe("Chicken & avocado salad with blueberry balsamic dressing",
                        "A healthy, gluten-free dinner or lunch, perfect for using up leftover roast chicken. Make it veggie by swapping the meat for a handful of pumpkin seeds.",
                        3,
                        Arrays.asList("1 garlic clove",
                                "85g blueberries",
                                "1 tbsp extra virgin rapeseed oil",
                                "2 tsp balsamic vinegar",
                                "125g fresh or frozen baby broad beans",
                                "1 large cooked beetroot, finely chopped",
                                "1 avocado, stoned, peeled and sliced",
                                "85g bag mixed baby leaf salad",
                                "175g cooked chicken"),
                        "Finely chop the garlic. Mash half the blueberries with the oil, vinegar and some black pepper in a large salad bowl." +
                                "\nBoil the broad beans for 5 mins until just tender. Drain, leaving them unskinned.\n" +
                                "\nStir the garlic into the dressing, then pile in the warm beans and remaining blueberries with the beetroot, avocado, salad and chicken. Toss to mix, but don’t go overboard or the juice from the beetroot will turn everything pink. Pile onto plates or into shallow bowls to serve.",

                        402,
                        "chicken_blueberry_salad.jpg",
                        4, false, 0),

                new Recipe("Custard tart with nutmeg pastry",
                        "There's something so honest about a custard tart, simply topped with a grating of nutmeg",
                        4,
                        Arrays.asList("500g pack shortcrust pastry",
                                "1 whole nutmeg, for grating",
                                "4 large eggs",
                                "140g golden caster sugar",
                                "300ml double cream",
                                "300ml whole milk",
                                "1 vanilla pod, seeds scraped out"),
                        "Heat oven to 200C/180C fan/gas 6. Roll the pastry out to about 1cm thick, then grate over a dusting of nutmeg using a fine grater. Fold the dough in half, then roll out again, to the thickness of 2 x £1 coins and large enough to line a 20cm loose-bottomed sandwich tin with some overhang. Press the pastry into the tin (leaving the excess draped over the sides), put onto a baking sheet and chill for 10 mins. Line the pastry with baking parchment and fill with baking beans. Bake for 20 mins, then remove beans and paper. Bake for another 15 mins until golden and sandy all over. Trim the edges of the tart with a sharp serrated knife.\n" +
                                "\nTurn oven down to 150C/130C fan/ gas 2. Whisk together the eggs and sugar in a large bowl. Put the cream, milk, vanilla pod and seeds into a saucepan and bring to the boil. Pour onto the eggs, whisking as you go. Sieve into a jug. Put the baking sheet onto the pulled-out oven rack, then pour in the custard, right to the top. You may not need every last drop. Grate over a nice layer of nutmeg, then slide gently back into the oven and bake for 1 hr. When it’s ready, the tart should be set and pale golden on the top, and have just the merest tremor in the centre when you jiggle the tray. Cool completely, then serve in slices.",

                        405,
                        "custard_tart_with_nutmeg_pastry.jpg",
                        4.7f, true, 5),

                new Recipe("Chicken with tomato & olives",
                        "A quick and easy one-pot dish for summer - great for using up leftover cooked chicken",
                        1,
                        Arrays.asList("20g pack basil",
                                "2 tbsp oil",
                                "2 garlic cloves, thinly sliced",
                                "2 x 400g or 14oz cans cherry tomatoes",
                                "1 tsp sugar",
                                "handful olives",
                                "sliced meat from a whole cooked chicken, plus any juices",
                                "crusty bread, to serve"),
                        "Finely chop the stalks from a 20g pack basil and shred most of the leaves. Heat 2 tbsp oil in a medium frying pan, then soften 2 thinly sliced garlic cloves and the basil stalks for 3 mins.\n" +
                                "\nTip in 2 x 400g cans cherry tomatoes, 1 tsp sugar and the shredded basil. Bring to a boil, then simmer for 15 mins until reduced and saucy. Season. Add a handful olives, the sliced meat from a whole cooked chicken and any juices. Gently stir. Simmer for 2 mins, scatter with basil leaves, then serve with crusty bread.",

                        531,
                        "chicken_with_tomato_and_olives.jpg",
                        4.4f, false, 4),

                new Recipe("Turkey burgers",
                        "If you find it hard to get your kids to eat high-fibre food, these burgers contain hidden oats",
                        1,
                        Arrays.asList("2 tbsp olive oil",
                                "1 large onion, finely chopped",
                                "2 garlic cloves, crushed",
                                "85g porridge oats",
                                "450g/1lb minced turkey",
                                "100g dried apricot, finely chopped",
                                "1 large carrot, grated",
                                "1 egg, beaten",
                                "rolls and cucumber slices, to serve"),
                        "Heat 1 tbsp oil in a pan and gently fry the onion for 5 mins until soft. Add the garlic and cook for 1 min. Add the oats and fry for 2 mins more. Tip into a bowl and set aside to cool.\n" +
                                "\nAdd the rest of the ingredients to the cooled mixture and mix well with your hands. Season to taste and shape into 8 patties.\n" +
                                "\nHeat oven to 200C/fan 180C/gas 6. Heat the remaining olive oil in a large, non-stick frying pan and sear the burgers on each side until well coloured (3-4 mins). Transfer to a baking sheet and cook in the oven for 10-15 mins. Serve in rolls with Tangy tomato chutney (see 'goes well with') and cucumber slices.\n" +
                                "\nFor the chutney heat 1 tbsp of olive oil in a pan and add 1 finely chopped onion. Cook for 5 mins until softened. Stir in 1 crushed garlic clove and cook for a further min. Add 1 tbsp sundried tomato paste, a 400g can good-quality chopped tomatoes and a pinch of sugar. Gently cook for 20-25 mins until rich and thick. Season to taste, then leave to cool before serving.",
                        179,
                        "turkey_burgers.jpg",
                        3.8f, true, 0),

                new Recipe("Meat fondue",
                        "Revisit an 80s dinner party classic — the meat fondue. The assembly job can be done before your guests arrive. Make some sauces_condiments yourself and buy the rest",
                        1,
                        Arrays.asList("800g beef tenderloin or 4 rump steaks, cut into 1-inch cubes",
                                "1l good vegetable oil",
                                "\nTo serve:",
                                "crusty white bread",
                                "green salad"),
                        "Prepare your sauces_condiments (see below) in advance, and put in little bowls around the fondue burner, along with the meat, bread and salad. Season the meat.\n" +
                                "\nWhen your guests are ready to eat, fill your fondue pan half-full of vegetable oil and heat on the hob until it’s hot, but not smoking. You’re aiming for around 190C, but if you haven’t got a thermometer, throw in a cube of bread – when it takes about 30 secs to brown, it’s ready.\n" +
                                "\nPut the fondue burner on the table carefully so that it’s stable, then, following the manufacturer’s instructions, light the flame and put the pan on top.\n" +
                                "\nGive each guest a fondue fork for dunking the meat in the hot oil. It should take 25-30 secs for rare, 30-35 secs for medium and 45-60 secs for well done. When the meat is cooked, dip it into the sauces_condiments, and pile it onto the bread. If you have some raw king prawns to cook in the fondue, they work really well too.\n" +
                                "\nSAUCES\n" +
                                "\nHorseradish sauce" +
                                "\nMix 1 tbsp grated horseradish with 3 tbsp sour cream, juice 1 lemon and a pinch each of salt, pepper and cayenne pepper. Chill until serving.\n" +
                                "\nChilli vinegar" +
                                "\nMix 3 tbsp white wine vinegar with 2 tsp sugar, 1 garlic clove, grated, and 1 medium red chilli, finely chopped. Set aside until needed.\n" +
                                "\nSalsa verde" +
                                "\nPut handful each parsley, basil, mint, coriander and tarragon in a blender with 1 tsp Dijon mustard, 1 tbsp red wine vinegar, 2 tbsp olive oil, 4 anchovies and 1 garlic clove, grated. Whizz together.\n" +
                                "\nAïoli" +
                                "\nMix 3 tbsp mayo with juice 1 lemon, 1 tsp Dijon mustard and 1 garlic clove, grated. Chill until needed.",
                        321,
                        "meat_fondue.jpg",
                        4.9f, true, 3),

                new Recipe("Sweet shortcrust pastry",
                        "Learn how to make sweet shortcrust pastry. You'll be surprised how easy it is, then you can make all sorts of desserts like our apple and blackberry pies",
                        4,
                        Arrays.asList("150g plain flour",
                                "75g unsalted butter",
                                "50g icing sugar",
                                "1 egg yolk"),
                        "Put 150g plain flour and 75g unsalted butter in a bowl and rub together with your fingertips until it resembles breadcrumbs.\n" +
                                "\nMix in 50g icing sugar and a pinch of salt followed by 1 egg yolk. If the pastry feels too dry to form a dough, add 1 tbsp water. Shape the dough into a ball, flatten it out into a disc, wrap it in cling film, then chill for at least 30 mins before using in your recipes.",

                        275,
                        "sweet_shortcrust_pastry.jpg",
                        4.1f, false, 0),

                new Recipe("Savoury Danish pastries",
                        "Give morning pastries a bakeover by swapping the sweet for a savoury butternut squash, blue cheese, bacon, onion and beetroot filling",
                        4,
                        Arrays.asList("200g block of butter",
                                "500g bag white bread mix",
                                "1 egg, beaten, to glaze",
                                "cornichons, to serve",
                                "\nFor the filling:",
                                "200g butternut squash, diced",
                                "6 rashers streaky bacon, cooked until crispy and roughly chopped",
                                "200g Danish blue cheese",
                                "2 tsp caraway or fennel seeds",
                                "50g walnut, roughly chopped",
                                "1 small red onion, thinly sliced",
                                "2 cooked beetroot, not in vinegar, diced",
                                "25g spinach leaves, chopped"),
                        "Wrap the butter in foil and freeze for 45 mins." +
                                "\nTip the bread mix into a bowl and, using the foil to hold it, coarsely grate in the butter – keep dipping the end in the flour to stop it sticking to the grater too much. Use a cutlery knife to stir together, then add 300ml cold water and stir to a dough.\n" +
                                "\nPut the squash in a microwave-proof bowl with a little water, cover with cling film, poke one hole in, and microwave on High, at 2-min increments, until just cooked. Drain any liquid.\n" +
                                "\nHeat oven to 200C/180C fan/gas 6. Roll out the dough as thinly as you can, to a rectangle with longest side measuring 25cm. Scatter over all the filling ingredients, spreading as evenly as you can, leaving a small gap along one of the longest sides, brush this edge with a little beaten egg. Season, then roll up tightly from the opposite side and pinch to seal. Use a sharp, floured knife to cut roll into 8 slices. Dust a baking sheet with more flour and place slices, cut-side up, with gaps in between. Brush tops with more egg and bake for 15-20 mins until golden and risen. Best eaten warm with cornichons.",
                        532,
                        "savoury_danish_pastries.jpg",
                        4.4f, false, 1),

                new Recipe("Greek salad",
                        "Make a fresh and colourful Greek salad in no time. It's great with grilled meats at a barbecue, or on its own as a veggie main",
                        3,
                        Arrays.asList("4 large vine tomatoes, cut into irregular wedges",
                                "1 cucumber, peeled, deseeded, then roughly chopped",
                                "½ a red onion, thinly sliced",
                                "16 Kalamata olives",
                                "1 tsp dried oregano",
                                "85g feta cheese, cut into chunks (barrel matured feta is the best)",
                                "4 tbsp Greek extra virgin olive oil"),
                        "Place 4 large vine tomatoes, cut into wedges, 1 peeled, deseeded and chopped cucumber, ½ a thinly sliced red onion, 16 Kalamata olives, 1 tsp dried oregano, 85g feta cheese chunks and 4 tbsp Greek extra virgin olive oil in a large bowl.\n" +
                                "\nLightly season, then serve with crusty bread to mop up all of the juices.",

                        270,
                        "greek_salad.jpg",
                        4.7f, false, 3),

                new Recipe("Braised beef with cranberries & spices",
                        "Slow cook beef with cinnamon, saffron, coriander and harissa for a deeply fragrant rustic casserole",
                        1,
                        Arrays.asList("2 tbsp olive oil",
                                "8 thick braising steaks, 1kg meat in total",
                                "2 large onions, very finely chopped, preferably in a food processor",
                                "4 garlic cloves, sliced",
                                "25g ginger, peeled and cut into slivers",
                                "good pinch saffron",
                                "2 cinnamon sticks, snapped in half",
                                "1 tbsp ground coriander",
                                "1 tbsp harissa",
                                "2 tbsp ground almond",
                                "1.2l hot beef stock",
                                "2 bay leaves",
                                "85g dried cranberries"),
                        "Heat the oil in a large flameproof casserole dish. Add the steaks 4 at a time and brown them well on both sides, then transfer to a plate. Now add the onions, garlic and ginger to the oil, plus juices left in the dish, and fry for at least 15 mins, stirring very frequently, until they are golden and soft. Add the saffron, cinnamon sticks, coriander, harissa and ground almonds, and stir well for 1 min.\n" +
                                "\nTip in the stock, then return the meat to the dish. Add the bay leaves, cover and simmer for 1 hr. Remove the lid and cook for another 1 hr 30 mins, checking occasionally to ensure the mixture doesn’t catch on the bottom. Add the cranberries 10 mins before the end of the cooking time so they can plump up in the gravy. Check the beef after the cooking time – it should pull apart easily with 2 forks. If not, add a splash more water or stock and cook for another 30 mins. Remove cinnamon and bay leaves.\n" +
                                "\nTo freeze: Cool completely, then pack into freezer bags. Use within 3 months. Thaw in the bags at room temperature for 5-8 hrs depending on the bag size, although batches of 2 can be unwrapped and reheated in a pan with a little water in the base. This will also keep in the fridge for a couple of days if you don’t want to freeze it. Serve with mash, rice or couscous (or gluten-free alternative).",
                        306,
                        "braised_beef_with_cranberries_and_spices.jpg",
                        4.9f, false, 2),

                new Recipe("Summer couscous salad",
                        "Capture the flavours of summer in this simple, hearty couscous salad. With fried halloumi, vine tomatoes and courgettes, it's perfect for an al fresco lunch",
                        3,
                        Arrays.asList("250g couscous",
                                "250ml vegetable stock, boiling",
                                "400g can chickpeas, drained and rinsed",
                                "1-2 tbsp vegetable or olive oil",
                                "300g courgette, sliced on the slant",
                                "300g small vine-ripened tomatoes, halved",
                                "250g pack halloumi cheese, thickly sliced and then halved lengthways",
                                "\nFor the dressing:",
                                "125ml olive oil",
                                "3 tbsp lime juice",
                                "2 large garlic cloves, finely chopped",
                                "2 tbsp chopped fresh mint",
                                "½ tsp sugar"),
                        "Tip the couscous into a bowl, pour the boiling stock over and mix well with a fork. Cover with a plate and leave for 4 minutes. Meanwhile, tip all the dressing ingredients into a bowl and mix well. Fluff up the couscous with a fork, stir in the chickpeas and follow with half the dressing. Mix well and pile on to a large serving dish.\n" +
                                "\nHeat 1 tbsp oil in a large frying pan and fry the courgette slices over a high heat for 2-3 minutes until dark golden brown. Lift out on to kitchen paper. Now put the tomatoes cut-side down into the pan, and cook for another couple of minutes until tinged brown on the underside. Top the couscous with the courgettes and then the tomatoes.\n" +
                                "\nIf the pan is dry, pour in a little more oil and heat it up, then add the halloumi strips and fry for 2-3 minutes, turning them over from time to time, until crisp and sizzled brown. Pile on top of the tomatoes, and drizzle with the remaining dressing. Serve as soon as possible.",
                        721,
                        "summer_couscous_salad.jpg",
                        4.3f, false, 3),
                new Recipe("Creamy courgette & bacon pasta",
                        "A quick and creamy carbonara-style tagliatelle that showcases delicious courgettes contrasted with cream and pancetta",
                        5,
                        Arrays.asList("1 tsp olive oil",
                                "150g diced pancetta, or smoked bacon lardons",
                                "4 courgettes, coarsely grated",
                                "1 garlic clove, crushed",
                                "handful freshly grated parmesan",
                                "1 small tub (200g) low-fat crème fraîche",
                                "300g tagliatelle"),
                        "Heat the olive oil in a large frying pan and sizzle the pancetta or bacon for about 5 mins until starting to crisp. Turn up the heat and add the grated courgette to the pan. Cook for 5 mins or until soft and starting to brown then add the garlic and cook for a minute longer. Season and set aside.\n" +
                                "\nCook the tagliatelle according to the pack instructions and scoop out a cupful of cooking water. Drain the tagliatelle and tip into the frying pan with the bacon and courgette. Over a low heat toss everything together with the crème fraiche and half the Parmesan adding a splash of pasta water too if you need to loosen the sauce. Season to taste and serve twirled into bowls with the remaining Parmesan scattered over.",
                        483,
                        "creamy_courgette_bacon_pasta.jpg",
                        4.3f, false, 2),
                new Recipe("Thai-style steamed fish",
                        "Serve with Thai jasmine rice for a flavour-packed low-fat meal",
                        2,
                        Arrays.asList("2 trout fillets, each weighing about 140g/5oz",
                                "a small knob of fresh root ginger, peeled and chopped",
                                "1 small garlic clove, chopped",
                                "1 small red chilli(not bird's eye), seeded and finely chopped",
                                "grated zest and juice of 1 lime",
                                "3 baby pak choi, each quartered lengthways",
                                "2 tbsp soy sauce"),
                        "Nestle the fish fillets side by side on a large square of foil and scatter the ginger, garlic, chilli and lime zest over them. Drizzle the lime juice on top and then scatter the pieces of pak choi around and on top of the fish. Pour the soy sauce over the pak choi and loosely seal the foil to make a package, making sure you leave space at the top for the steam to circulate as the fish cooks.\n" +
                                "\nSteam for 15 minutes. (If you haven’t got a steamer, put the parcel on a heatproof plate over a pan of gently simmering water, cover with a lid and steam.)",
                        199,
                        "thai_style_steamed_fish.jpg",
                        3.3f, false, 1),
                new Recipe("Chicken noodle soup",
                        "Mary Cadogan's aromatic broth will warm you up on a winter's evening - it contains ginger, which is particularly good for colds, too",
                        6,
                        Arrays.asList("900ml chicken or vegetable stock (or Miso soup mix)",
                                "1 boneless, skinless chicken breast, about 175g/6oz",
                                "1 tsp chopped fresh root ginger",
                                "1 garlic clove, finely chopped",
                                "50g rice or wheat noodles",
                                "2 tbsp sweetcorn, canned or frozen",
                                "2-3 mushrooms, thinly sliced",
                                "2 spring onions, shredded",
                                "2 tsp soy sauce, plus extra for serving",
                                "mint or basil leaves and a little shredded chilli (optional), to serve"),
                        "Pour 900ml chicken or vegetable stock into a pan and add 1 boneless, skinless chicken breast, 1 tsp chopped root ginger and 1 finely chopped garlic clove.\n" +
                                "\nBring to the boil, then reduce the heat, partly cover and simmer for 20 mins, until the chicken is tender.\n" +
                                "\nRemove the chicken to a board and shred into bite-size pieces using a couple of forks.\n" +
                                "\nReturn the chicken to the stock with 50g rice or wheat noodles, 2 tbsp sweetcorn, 2-3  thinly sliced mushrooms, 1 shredded spring onion and 2 tsp soy sauce.\n" +
                                "\nSimmer for 3-4 mins until the noodles are tender.\n" +
                                "\nLadle into two bowls and scatter over the remaining shredded spring onion, mint or basil leaves and shredded chilli if using. Serve with extra soy sauce for sprinkling.",
                        217,
                        "chicken_noodle_soup.jpg",
                        3.3f, false, 1),
                new Recipe("Roasted vegetables",
                        "Add feta and basil to roasted vegetables for a perfect summer side dish. The trick is to cut all the veg the same size so they cook in the same amount of time",
                        7,
                        Arrays.asList("3 tbsp olive oil",
                                "1 aubergine",
                                "Aubergine, cut into chunks",
                                "2 mixed coloured peppers, such as orange and red, cut into chunks",
                                "1 red onion, cut into wedges",
                                "2 courgettes, cut into chunks",
                                "4 garlic cloves, smashed",
                                "3 sprigs of thyme",
                                "200g cherry tomatoes",
                                "handful of basil leaves",
                                "zest of 1 lemon",
                                "50g feta, crumbled"),
                        "Heat the oven to 200C/180C Fan/gas 6. Mix the oil with the aubergine, peppers, red onion, courgette, garlic and thyme in a bowl with sea salt and black pepper. Tip into a large roasting tin then roast for 30 mins. Add the tomatoes to the pan and return to the oven for 10 mins. \n" +
                                "\nSqueeze the garlic from their skins, remove the thyme then scatter over the basil, lemon zest and crumbled feta.",
                        198,
                        "roasted_vegetables.jpg",
                        3.3f, true, 1),
                new Recipe("Pizza Margherita in 4 easy steps",
                        "Even a novice cook can master the art of pizza with our simple step-by-step guide. Bellissimo",
                        8,
                        Arrays.asList("300g strong bread flour",
                                "1 tsp instant yeast(from a sachet or a tub)",
                                "1 tsp salt",
                                "1 tbsp olive oil, plus extra for drizzling",
                                "/nFor the tomato sauce",
                                "100ml passata",
                                "handful fresh basil or 1 tsp dried",
                                "1 garlic clove, crushed",
                                "\nFor the topping",
                                "125g ball mozzarella, sliced",
                                "handful grated or shaved parmesan(or vegetarian alternative)",
                                "handful cherry tomatoes, halved",
                                "\nTo finish",
                                "handful basil leaves (optional)"),
                        "Make the base: Put the flour into a large bowl, then stir in the yeast and salt. Make a well, pour in 200ml warm water and the olive oil and bring together with a wooden spoon until you have a soft, fairly wet dough. Turn onto a lightly floured surface and knead for 5 mins until smooth. Cover with a tea towel and set aside. You can leave the dough to rise if you like, but it’s not essential for a thin crust.\n" +
                                "\nMake the sauce: Mix the passata, basil and crushed garlic together, then season to taste. Leave to stand at room temperature while you get on with shaping the base.\n" +
                                "\nRoll out the dough: If you’ve let the dough rise, give it a quick knead, then split into two balls. On a floured surface, roll out the dough into large rounds, about 25cm across, using a rolling pin. The dough needs to be very thin as it will rise in the oven. Lift the rounds onto two floured baking sheets.\n" +
                                "\nTop and bake: Heat oven to 240C/fan 220C /gas 8. Put another baking sheet or an upturned baking tray in the oven on the top shelf. Smooth sauce over bases with the back of a spoon. Scatter with cheese and tomatoes, drizzle with olive oil and season. Put one pizza, still on its baking sheet, on top of the preheated sheet or tray. Bake for 8-10 mins until crisp. Serve with a little more olive oil, and basil leaves if using. Repeat step for remaining pizza.",
                        431,
                        "margherita_4_easy_steps.jpg",
                        4.3f, true, 1),
                new Recipe("Spicy vegetable chapati wraps",
                        "A delicious and healthy vegetarian low-fat alternative to a curry, which can be deceivingly high in fat",
                        9,
                        Arrays.asList("150g sweet potato",
                                "Sweet potatoes, peeled and roughly cubed",
                                "200g can peeled plum tomatoes",
                                "200g can chickpeas, drained",
                                "½ tsp dried chilli flakes",
                                "1 tbsp mild curry paste",
                                "50g baby spinach leaves",
                                "1 tbsp chopped, fresh coriander",
                                "2 plain chapatis (Indian flatbreads)",
                                "2 tbsp fat-free Greek or natural yogurt"),
                        "Cook the sweet potatoes in a pan of boiling water for 10-12 minutes until tender. Meanwhile, put the tomatoes, chickpeas, chilli flakes and curry paste in another pan and simmer gently for about 5 minutes.\n" +
                                "\nPreheat the grill. Drain the sweet potatoes and add to the tomato mixture. Stir in the spinach and cook for a minute until just starting to wilt. Stir in the coriander, season to taste and keep warm.\n" +
                                "\nSprinkle the chapatis with a little water and grill for 20-30 seconds each side. Spoon on the filling, top with yogurt and fold in half to serve",
                        289,
                        "spicy_vegetable_chapati_wraps.jpg",
                        4.3f, true, 1),
                new Recipe("Pesto sauce",
                        "Make your own delicious pesto sauce in just 15 minutes",
                        10,
                        Arrays.asList("50g pine nuts",
                                "large bunch of basil",
                                "50g parmesan(or vegetarian alternative)",
                                "150ml olive oil, plus extra for storing",
                                "2 garlic cloves"),
                        "Heat a small frying pan over a low heat. Cook the pine nuts until golden, shaking occasionally. Put into a food processor with the remaining ingredients and process until smooth, then season.\n" +
                                "\nPour the pesto into a jar and cover with a little extra oil, then seal and store in the fridge. It will keep in a fridge for up to two weeks.",
                        110,
                        "pesto_sauce.jpg",
                        4.3f, false, 3),
                new Recipe("Ultimate chocolate cake",
                        "Indulge yourself with this ultimate chocolate cake recipe that is beautifully moist, rich and fudgy. Perfect for a celebration or an afternoon tea",
                        11,
                        Arrays.asList("200g dark chocolate(about 60% cocoa solids), chopped",
                                    "200g butter, cubed",
                                    "1 tbsp instant coffee granules",
                                    "85g self-raising flour",
                                    "85g plain flour",
                                    "¼ tsp bicarbonate of soda",
                                    "200g light muscovado sugar",
                                    "200g golden caster sugar",
                                    "25g cocoa powder",
                                    "3 medium eggs",
                                    "75ml buttermilk",
                                    "50g grated chocolate or 100g curls, to decorate",
                                    "\nFor the ganache",
                                    "200g dark chocolate(about 60% cocoa solids), chopped",
                                    "300ml double cream",
                                    "2 tbsp golden caster sugar"),
                        "Heat the oven to 160C/ fan140C/ gas 3. Butter and line a 20cm round cake tin (7.5cm deep).\n" +
                                "\nPut 200g chopped dark chocolate in a medium pan with 200g butter.\n" +
                                "\nMix 1 tbsp instant coffee granules into 125ml cold water and pour into the pan.\n" +
                                "\nWarm through over a low heat just until everything is melted – don’t overheat. Or melt in the microwave for about 5 minutes, stirring halfway through.\n" +
                                "\nMix 85g self-raising flour, 85g plain flour, ¼ tsp bicarbonate of soda, 200g light muscovado sugar, 200g golden caster sugar and 25g cocoa powder, and squash out any lumps.\n" +
                                "\nBeat 3 medium eggs with 75ml buttermilk.\n" +
                                "\nPour the melted chocolate mixture and the egg mixture into the flour mixture and stir everything to a smooth, quite runny consistency.\n" +
                                "\nPour this into the tin and bake for 1hr 25 – 1hr 30 mins. If you push a skewer into the centre it should come out clean and the top should feel firm (don’t worry if it cracks a bit).\n" +
                                "\nLeave to cool in the tin (don’t worry if it dips slightly), then turn out onto a wire rack to cool completely. Cut the cold cake horizontally into three.\n" +
                                "\nTo make the ganache, put 200g chopped dark chocolate in a bowl.  Pour 300ml double cream into a pan, add 2 tbsp golden caster sugar and heat until it is about to boil.\n" +
                                "\nTake off the heat and pour it over the chocolate. Stir until the chocolate has melted and the mixture is smooth. Cool until it is a little thicker but still pourable.\n" +
                                "\nSandwich the layers together with just a little of the ganache. Pour the rest over the cake letting it fall down the sides and smooth over any gaps with a palette knife.\n" +
                                "\nDecorate with 50g grated chocolate or 100g chocolate curls. The cake keeps moist and gooey for 3-4 days.",
                        541,
                        "ultimate_chocolate_cake.jpg",
                        4.3f, false, 0),
                new Recipe("Apple & walnut marmalade",
                        "Easy and versatile, this preserve is great with scones",
                        12,
                        Arrays.asList("450g dessert apple",
                                "50g butter",
                                "85g light muscovado sugar",
                                "1 small lemon, zest, juice and squeezed out halves",
                                "1 bay leaf",
                                "1 tbsp brandy(optional)",
                                "100g walnut, roughly chopped"),
                        "Quarter and core the apples (no need to peel) and cut each quarter in half again. In a large frying pan, melt the butter, then add the apples, sugar, lemon zest and juice and the squeezed-out lemon halves and bay leaf. Carefully stir everything to combine, then cover and cook gently for about 10 mins or until the apples are just soft.\n" +
                                "\nRemove the lid and turn the heat to high. Allow the mixture to cook, uncovered, for a further 5 mins, or until most of the excess liquid has evaporated. It should be juicy and syrupy. Remove the lemon halves and bay, stir in the brandy, if using, and leave to cool slightly. Stir in the walnuts and serve warm.",
                        0,
                        "apple_walnut_marmalade.jpg",
                        4.3f, false, 1),
                new Recipe("Rum punch",
                        "Shivi Ramoutar's recipe for this classic Caribbean cocktail combines sweet and sour flavours for a fruity weekend tipple",
                        13,
                        Arrays.asList("175ml freshly squeezed orange juice",
                                "75ml freshly squeezed lime juice",
                                "150ml good-quality golden rum",
                                "50ml sugar syrup",
                                "dash of grenadine syrup",
                                "dash of Angostura bitters",
                                "ice cubes, to serve",
                                "generous pinch of freshly grated nutmeg",
                                "2 thick slices orange, to garnish",
                                "maraschino cherries, to garnish"),
                        "Pour the juices, rum, sugar syrup, grenadine and Angostura bitters into a large jug and give it a good stir. Pop into the fridge to chill for 1 hr.\n" +
                                "\nServe over ice cubes, sprinkle over the nutmeg and garnish with an orange slice and maraschino cherry, speared with a cocktail stick.",
                        271,
                        "rum_punch.jpg",
                        4.7f, true, 3)

        };
    }

    static Category[] initializeCategories() {

        return new Category[]{new Category(Category.Type.MEAT, "meat"),
                new Category(Category.Type.FISH, "fish"),
                new Category(Category.Type.SALAD, "salad"),
                new Category(Category.Type.PASTRY, "pie_pastry"),
                new Category(Category.Type.PASTA, "pasta"),
                new Category(Category.Type.SOUP, "soup"),
                new Category(Category.Type.VEGETABLE_SIDES, "vegetable_sides"),
                new Category(Category.Type.PIZZA, "pizza"),
                new Category(Category.Type.SANDWICHES_WRAPS, "sandwiches_wraps"),
                new Category(Category.Type.SAUCES_CONDIMENTS, "sauces_condiments"),
                new Category(Category.Type.CAKE, "cake"),
                new Category(Category.Type.DESSERTS, "desserts"),
                new Category(Category.Type.BEVERAGES, "beverages")};

    }
}
