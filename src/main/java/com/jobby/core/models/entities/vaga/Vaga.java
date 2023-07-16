
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_vaga")
@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode exceder 100 caracteres")
    private String nome;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Profissao cargo;
}
