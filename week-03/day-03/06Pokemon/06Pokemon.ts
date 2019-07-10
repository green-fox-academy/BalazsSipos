
import { Pokemon } from './Pokemon'

let pokemonOfAsh: Pokemon[] = initializePokemon();

// Every pokemon has a name and a type.
// Certain types are effective against others, e.g. water is effective against fire.

// Ash has a few pokemon.
// A wild pokemon appeared!

let wildPokemon: Pokemon = new Pokemon('Oddish', 'leaf', 'water');


// Creates an array with 5 pokemons
function initializePokemon(): Pokemon[] {
  return [
    new Pokemon('Balbasaur', 'leaf', 'water'),
    new Pokemon('Pikatchu', 'electric', 'water'),
    new Pokemon('Charizard', 'fire', 'leaf'),
    new Pokemon('Balbasaur', 'water', 'fire'),
    new Pokemon('Kingler', 'water', 'fire')
  ];
}

class PokemonCollector {
  pokemons: Pokemon[];

  constructor(pokemons: Pokemon[]) {
    this.pokemons = pokemons;
  }

  // It will chose the FIRST pokemon from the pokemons property (array of pokemons), that beats the given pokemon added to the method
  pokemonChooser(pokemon: Pokemon): Pokemon {
    let pokemons: Pokemon[] = this.pokemons;

    for (let i: number = 0; i < pokemons.length; i++) {
      if (pokemons[i].isEffectiveAgainst(pokemon)) {
        return pokemons[i];
      }
    }
  }
}

let allPokemons = new PokemonCollector(pokemonOfAsh);

// Which pokemon should Ash use?
let chosenPokemon: Pokemon = allPokemons.pokemonChooser(wildPokemon);

console.log('I choose you, ' + chosenPokemon.name);
