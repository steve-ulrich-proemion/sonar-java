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

import com.google.common.base.Preconditions;
import com.sonar.sslr.api.AstNode;
import org.sonar.java.model.JavaTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.LabeledStatementTree;
import org.sonar.plugins.java.api.tree.StatementTree;
import org.sonar.plugins.java.api.tree.TreeVisitor;

public class LabeledStatementTreeImpl extends JavaTree implements LabeledStatementTree {
  private final IdentifierTree label;
  private final StatementTree statement;

  public LabeledStatementTreeImpl(AstNode astNode, IdentifierTree label, StatementTree statement) {
    super(astNode);
    this.label = Preconditions.checkNotNull(label);
    this.statement = Preconditions.checkNotNull(statement);
  }

  @Override
  public Kind getKind() {
    return Kind.LABELED_STATEMENT;
  }

  @Override
  public IdentifierTree label() {
    return label;
  }

  @Override
  public StatementTree statement() {
    return statement;
  }

  @Override
  public void accept(TreeVisitor visitor) {
    visitor.visitLabeledStatement(this);
  }
}
