/*
 * SonarQube Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.java.model.statement;

import com.sonar.sslr.api.AstNode;
import org.sonar.java.model.JavaTree;
import org.sonar.plugins.java.api.tree.ContinueStatementTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.TreeVisitor;

import javax.annotation.Nullable;

public class ContinueStatementTreeImpl extends JavaTree implements ContinueStatementTree {
  @Nullable
  private final IdentifierTree label;

  public ContinueStatementTreeImpl(AstNode astNode, @Nullable IdentifierTree label) {
    super(astNode);
    this.label = label;
  }

  @Override
  public Kind getKind() {
    return Kind.CONTINUE_STATEMENT;
  }

  @Nullable
  @Override
  public IdentifierTree label() {
    return label;
  }

  @Override
  public void accept(TreeVisitor visitor) {
    visitor.visitContinueStatement(this);
  }
}
