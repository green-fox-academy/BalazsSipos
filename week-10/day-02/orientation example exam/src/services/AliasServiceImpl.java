package services;

import models.DTOs.AliasDTO;
import models.entities.Alias;
import repositories.AliasRepository;

@Service
public class AliasServiceImpl implements AliasService {
    private AliasRepository aliasRepository;

    @Autowired
    public AliasServiceImpl(AliasRepository aliasRepository) {
        this.aliasRepository = aliasRepository;
    }

    @Override
    public AliasDTO convertFromAliasToAliasDTO(Alias alias) {
        AliasDTO aliasDTO;
        if(alias != null) {
            aliasDTO = new AliasDTO(alias.getId(), alias.getUrl(), alias.getAlias(), alias.getHitCount());
        } else {
            aliasDTO = new AliasDTO();
        }
        return aliasDTO;
    }

    @Override
    public Alias findAliasById(String alias) {
        Optional<Alias> optionalAlias = this.aliasRepository.findByAlias(alias);
        if(optionalAlias.isPresent()) {
            return optionalAlias.get();
        }
        return null;
    }

    @Override
    public Alias updateNewAlias(Alias alias) {
        this.aliasRepository.save(alias);
    }

    @Override
    public Alias convertFromAliasDTOToAlias(AliasDTO aliasDTO) {
        Alias alias;
        if(aliasDTO != null) {
            alias = new Alias(aliasDTO.getUrl(), aliasDTO.getAlias(), aliasDTO.getHitCount(), this.randomGenerator(1000,9000.0))
        } else {
            alias = new Alias();
        }
    }

    private int randomGenerator(int minValue, Double maxValue) {
        return (int) (maxValue * Math.random() + minValue);
    }


}
