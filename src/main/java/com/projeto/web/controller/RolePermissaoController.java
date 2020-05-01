package com.projeto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Escopo;
import com.projeto.model.Permissao;
import com.projeto.model.Role;
import com.projeto.model.RolePermissao;
import com.projeto.model.RolePermissaoId;
import com.projeto.service.EscopoService;
import com.projeto.service.PermissaoService;
import com.projeto.service.RolePermissaoService;
import com.projeto.service.RoleService;

@Controller
@RequestMapping(value="/admin/roles/permissao")
public class RolePermissaoController {
	
	@Autowired
	private RoleService rs;
	@Autowired
	private PermissaoService ps;
	@Autowired
	private EscopoService es;
	@Autowired
	private RolePermissaoService rps;
	
	@RequestMapping(method = RequestMethod.GET, value="/list")
	public ModelAndView listarRolePermissoes() {
	
		RolePermissao rp = new RolePermissao();
		ModelAndView mv = new ModelAndView("/permissao/listaRolePermissao");
		List<RolePermissao> listaRolePermissao = rps.findAll();
		mv.addObject("listaRolePermissao", listaRolePermissao);
		mv.addObject("RolePermissao", rp);
		return mv;
	}
	
	@RequestMapping(value = "/nova",method = RequestMethod.POST)
	public String save(RolePermissao rolePermissao) {
		
		RolePermissaoId id = new RolePermissaoId();
		
		id.setRoleId(rolePermissao.getRole().getId());
		id.setEscopoId(rolePermissao.getEscopo().getId());
		id.setPermissaoId(rolePermissao.getPermissao().getId());
		rolePermissao.setId(id);
		
		rps.save(rolePermissao);
		
		return "redirect:/admin/roles/permissao/list";
	}
	
	@RequestMapping(value = "/{roleId}/{permissaoId}/{escopoId}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Long roleId, @PathVariable Long permissaoId, @PathVariable Long escopoId) {
		
		
		RolePermissaoId id = new RolePermissaoId();
		
		id.setEscopoId(escopoId);
		id.setPermissaoId(permissaoId);
		id.setRoleId(roleId);
				
		rps.deleteById(id);
		
		
		return listarRolePermissoes();
		
	}
	
	@ModelAttribute("roles")
	public List<Role> listarRoles() {
		return rs.findAll();
	}
	
	@ModelAttribute("permissoes")
	public List<Permissao> listarPermissoes() {
		return ps.findAll();
	}
	
	@ModelAttribute("escopos")
	public List<Escopo> listarEscopos() {
		return es.findAll();
	}
}
