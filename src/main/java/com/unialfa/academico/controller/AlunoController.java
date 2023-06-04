package com.unialfa.academico.controller;

import com.unialfa.academico.model.Aluno;
import com.unialfa.academico.service.AlunoService;
import com.unialfa.academico.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/lista")
    public String iniciarLista(Model model){
        model.addAttribute("boasVindas", "Lista de Alunos");
        model.addAttribute("listaDeAlunos",service.listarTodos());
        return "aluno/lista";
    }

    @GetMapping("/formulario")
    public String iniciarForm(Model model, Aluno aluno){
        model.addAttribute("boasVindas","Cadastro de Alunos");
        model.addAttribute("listaDeCursos", cursoService.listarTodos());
        return "aluno/formulario";
    }
    @PostMapping("/salvar")
    public String salvar(Aluno aluno){
        service.salvar(aluno);
        return "redirect:/aluno/lista";
    }
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable long id, Model model){
        model.addAttribute("boasVindas", "Lista de Alunos");
        model.addAttribute("aluno",service.buscarPorId(id));
        model.addAttribute("listaDeCursos", cursoService.listarTodos());
        return "aluno/formulario";
    }
    @GetMapping("/remover/{id}")
    public String remover(@PathVariable long id){
        service.remover(id);
        return "redirect:/aluno/lista";
    }
}
