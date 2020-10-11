<template id="observations-detail">
    <div class="content-wrapper">
        <div v-if="observations" class="detail-planet-system-container">
            <img v-if="observations.bird != null" class="cover-image" v-bind:src="observations.bird.pictureURL">
            <img v-else-if="observations.amphibian != null" class="cover-image" v-bind:src="observations.amphibian.pictureURL">
            <img v-else-if="observations.invertebrate != null" class="cover-image" v-bind:src="observations.invertebrate.pictureURL">
            <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">



            {{console.log(this.observations)}}

            <h1 v-if="observations.bird">{{observations.bird.name}}</h1>
            <h1 v-else-if="observations.amphibian">{{observations.amphibian.name}}</h1>
            <h1 v-else-if="observations.invertebrate">{{observations.invertebrate.name}}</h1>

            <p v-if="observations.bird">The {{observations.bird.name}} has the scientific name {{observations.bird.scientificName}}.The animal is a {{observations.bird.animalType}} and the population is {{observations.bird.population}}.</p>

            <p v-else-if="observations.amphibian">The {{observations.amphibian.name}} has the scientific name {{observations.amphibian.scientificName}}.The animal is a {{observations.amphibian.animalType}} and the population is {{observations.amphibian.population}}.</p>

            <p v-else-if="observations.invertebrate">The {{observations.invertebrate.name}} has the scientific name {{observations.invertebrate.scientificName}}.The animal is a {{observations.invertebrate.animalType}} and the population is {{observations.invertebrate.population}}.</p>

            <p>It was first observed at {{observations.location.planetName}}, longitude: {{observations.location.longitude}}, latitude: {{observations.location.latitude}}</p>
            <p v-if="observations.invertebrate">Is a heard animal? {{observations.invertebrate.heardAnimal}}</p>
            <p v-else-if="observations.amphibian">Is it hibernating? {{observations.amphibian.hibernating}}</p>
            <p v-else>Can the bird fly? {{observations.bird.canFly}}</p>
        </div>

    </div>
</template>
<script>
    Vue.component("observations-detail", {
        template: "#observations-detail",
        data: () => ({
            observations: null,
        }),
        created() {
            const observationsName = this.$javalin.pathParams["observations-name"];
            fetch(`/api/observations/${observationsName}`)
                .then(res => res.json())
                .then(res => {
                    this.observations = res;
                })
                .catch(() => alert("Error while fetching observations"))
        }
    });
</script>
<style>

    .planet-overview-list{
        color:black;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;

    }

    #sortList{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        margin-top: 30px;
        margin-bottom: 30px;
    }

    #sortList li{
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    #sortList li a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    #sortList li:hover{
        border: 2px solid white;
    }

    div.detail-planet-system-container{
        padding: 10px;
        overflow: hidden;
        width: 750px;
        margin: 0 auto;
        background-color: rgba(20, 20, 20, 0.98);
        opacity: 0.96;
        color: white;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    div.single-planet-container{
        overflow: hidden;
        color: white;
        background-color: rgba(0, 0, 0, 0.98);
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    .single-star-container{
        height:100px;
        width:40%;
        background-color: #F0FFFF;
        opacity: 0.96;
        text-align: center;
        margin-left: 34%;
    }


    div.single-star-container:hover{
        height:115px;
        opacity:1.0;

    }

    img.cover-image {
        height: auto;
        width: 50%;
        margin: 5px;
        float: left;
    }

    img.list-image {
        width: 140px;
        padding-bottom: 20px;
        transition: transform .2s;
    }

   .list-image:hover{
       transform: scale(1.1);
   }

    h1{
        font-size:18px;
        padding-top: 10px;
    }

    .link-to-planet-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color:black;
    }

    .button {
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    button a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    .button:hover{
        border: 2px solid white;
    }

</style>
