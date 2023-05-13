package br.com.bode.springasync.cadastro.repository;

import br.com.bode.springasync.cadastro.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
