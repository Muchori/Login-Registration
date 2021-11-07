message "Thanks @#{github.pr_author}!"

if github.pr_body.length == 0
    fail "Please prove a summary in Pull Request description."
end

if git.lines_of code > 500
    warn "Please consider breaking up this pull request."
end

if github.pr_labels.empty?
    warn "Please add labels tp this PR."
end

if git.deletions > git.additions
    message "🎉 Code Cleanup!"
end